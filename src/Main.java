import java.util.Scanner;

public class Main {
    public static final String fileName = "Data.txt";
    public static final String console_file = "console_output.txt";

    public static void main(String[] args) {

        int choice;
        Scanner sc = new Scanner(System.in);
        MyList<Product> list = new MyList<>();

        do{
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID");
            System.out.println("8. Convert to Binary");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display");
            System.out.println("11. Sort by Recursion");
            System.out.println("0. Exit");

            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: {// doc du lieu tu file va in ra man hinh
                    OperationToProduct p = new OperationToProduct();
                    if(!list.fileIsEmpty(fileName)){
                        list.clear();
                        p.readFile(fileName, list);
                        list.showList();
                    }else {
                        System.out.println("File is empty");
                    }
                    break;
                }
                case 2:{// Them san pham vao cuoi danh sach
                    System.out.println("Add a new product: ");
                    OperationToProduct p = new OperationToProduct();
                    System.out.println("How many products that you want to import? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i< n; i++){
                        System.out.println("Enter product's information: ");
                        Product newProduct = new Product();
                        p.inputProduct(newProduct, sc);
                        p.addLast(newProduct, list);
                    }
                    break;
                }
                case 3:{// In danh sach san pham ra man hinh
                    if(list.isEmpty()){
                        System.out.println("List is empty");
                    }else {
                        System.out.println("List product: ");
                        list.showList();
                    }
                    break;
                }
                case 4:{// ghi du lieu tu danh sach vao file
                    if(!list.isEmpty()){
                        list.writeToFile(fileName);
                    }else {
                        System.out.println("List is empty");
                    }
                    break;
                }
                case 5: {// Tim kiem san pham bang ID
                    if(list.isEmpty()){
                        System.out.println("List is empty");
                    }else {
                        System.out.println("Search by ID: ");
                        String id = sc.nextLine();
                        Product product = new Product(id);
                        OperationToProduct p = new OperationToProduct();
                        var result = p.searchById(product, list);
                        if(result != null){
                            System.out.println(result);
                        }else {
                            System.out.println("Not Find");
                        }
                    }
                    break;
                }
                case 6:{// xoa san pham bang ID
                    if(list.isEmpty()){
                        System.out.println("List is empty");
                    }else {
                        System.out.println("Delete by ID: ");
                        String id = sc.nextLine();
                        Product product = new Product(id);
                        OperationToProduct p = new OperationToProduct();
                        var result = p.deleteByID(product, list);

                        if(result){// neu xoa thanh cong reset lai file
                            System.out.println("Succesfully Deleted");
                            list.resetFile(fileName);
                            list.writeToFile(fileName);
                        }else {
                            System.out.println("Unsuccesfully Deleted");
                        }
                        break;
                    }
                }
                case 7:{//sap xep san pham theo ID
                    System.out.println("List of product was sortes by ID: ");
                    list.sortList();
                    list.showList();
                    break;
                }
                case 8:{// covert so luong cua san pham dau danh sach thanh so nhi phan
                    if(list.isEmpty()){
                        System.out.println("List is empty");
                    }else {
                        System.out.println("Convert to binary: ");
                        MyStack<String> binary = new MyStack<>();
                        Product p = list.front().getData();
                        OperationToProduct index = new OperationToProduct();
                        index.changeTobinary(p, binary);
                        binary.showStackOfBinary();

                    }
                    break;
                }
                case 9:{// In danh sach san pham theo stack
                    if(!list.fileIsEmpty(fileName)){
                        System.out.println("Stack: ");
                        MyStack<Product> stackProduct = new MyStack<>();
                        stackProduct.clearStack();
                        stackProduct = stackProduct.readFile(fileName);
                        stackProduct.showStack();
                    }else {
                        System.out.println("File is empty");
                    }
                    break;
                }
                case 10:{// In danh sach san pham theo queue
                    if(!list.fileIsEmpty(fileName)){
                        System.out.println("Queue: ");
                        MyQueue<Product> queueProduct = new MyQueue<>();
                        queueProduct.clearQueue();
                        queueProduct = queueProduct.readFile(fileName);
                        queueProduct.showQueue();
                    }else {
                        System.out.println("File is empty");
                    }
                    break;

                }
                case 11: {//Sap xep danh sach san pham bang de quy
                    if(list.isEmpty()){
                        System.out.println("List is empty");
                    }else {
                        System.out.println("Sort by recursion: ");
                        OperationToProduct p = new OperationToProduct();
                        p.sortByRecursion(list);
                        p.showProduct(list);
                    }
                    break;
                }
            }
        }while (choice != 0);

    }
}