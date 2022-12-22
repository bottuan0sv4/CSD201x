import java.util.Scanner;

public class OperationToProduct {
    public void inputProduct(Product newProduct, Scanner sc){
        System.out.println("Bcode: ");
        newProduct.setBcode(sc.nextLine());
        System.out.println("Title: ");
        newProduct.setTitle(sc.nextLine());
        System.out.println("Quantity: ");
        newProduct.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.println("Price: ");
        newProduct.setPrice(Double.parseDouble(sc.nextLine()));
    }

    public void addLast(Product newProduct, MyList<Product> list){
        list.insertTail(newProduct);
    }

    public void showProduct(MyList<Product> list){list.showList();}

    public Product searchById(Product p, MyList<Product> list){
        Product searchedProduct = list.search(p).getData();
        if(searchedProduct != null){
            return searchedProduct;
        }else {
            return null;
        }
    }

    public boolean deleteByID(Product p, MyList<Product> list){
        if(list.removeNode(p)){
            return true;
        }else {
            return false;
        }
    }

    public void changeTobinary(Product p, MyStack<String> binary){
        p.covertToBinary(p.getQuantity(), binary);
    }

    public void sortProduct(MyList<Product> list){list.sortList();}
    public void sortByRecursion(MyList<Product> list){
        list.sortRecursion(list.front());
    }

    public void saveToFile(String fileName, MyList<Product> list){list.writeToFile(fileName);}

    public MyList<Product> readFile(String fileName, MyList<Product> list){
        return  list.readFromFile(fileName,list, true);
    }
}
