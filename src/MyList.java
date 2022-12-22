import java.io.*;

public class MyList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty(){
        return head == null;
    }

    public Node<T> front(){
        return head;
    }

    public T behind(){
        return tail.getData();
    }

    public void insertHead(T data){
        Node<T> p = new Node<>(data);
        if(isEmpty()){
            head = tail = p;
        }else {
            p.setNext(head);
            head = p;
        }
    }

    public void insertTail(T data){
        Node<T> p = new Node<>(data);
        if(isEmpty()){
            head = tail = p;
        }else {
            tail.setNext(p);
            tail = p;
        }
    }

    public boolean removeNode(T data){
        Node<T> x = head;
        Node<T> prevX = head;

        if(!isEmpty()){
            while (x != null){ // duyet tu dau danh sach
                if(x.getData().equals(data)){// Neu gia tri cua node va gia tri truyen vao bang nhau
                    break; // ket thuc vong lap
                }
                prevX = x; // neu khong thi cap nhat prevX
                x = x.getNext();// cap nhat x thanh node tiep theo
            }
            if(x != null){// sau khi duyet het danh sach, kiem tra neu node x != null
                if(x == head){// neu x la head
                    head = x.getNext(); // gan node head la node phia sau x
                    x.setNext(null);// ngat lien ket cua x
                } else if (x == tail) {// neu x la tail
                    prevX.setNext(null);// ngat lien ket cua node truoc x voi x
                    tail = prevX;// tail la node phia truoc x
                }else {// neu node can xoa nam giua danh sach
                    prevX.setNext(x.getNext());// cho node phia truoc x lien ket voi node phia sau x
                    x.setNext(null);// ngat ket noi cua x
                }return true;// da xoa thanh cong
            }else {// neu duyet het danh sach ma x == null thi xoa khong thanh cong
                return false;
            }
        }else {// neu danh sach rong thi xoa khong thanh cong
            System.out.println("Empty");
            return false;
        }
    }

    public void sortRecursion(Node<T> current){
        if(current != null){
            T temp = current.getData();// Luu lai gia tri cua node hien tai
            T x = findMinIndex(current.getData(), current);// Tim gia tri ngo nhat trong khoang tu phia sau node hien
            // tai cho toi khi null
            Node<T> min = search(x); // Tim kiem trong danh sach node co gia tri nho nhat vua tim duoc
            current.setData(x);// doi cho gia tri cua node hien tai va node co gia tri nho nhat vua tim duoc
            min.setData(temp);
            sortRecursion(current.getNext());// thuc hien de quy voi node phia sau
        }
    }

    public T findMinIndex(T minIndex, Node<T> current){
        if(current.getNext() == null){// neu node phia sau null
            return minIndex; // tra ve gia tri nho nhat o hien tai
        }
        if(current.getNext().getData().compareTo(minIndex) <= 0) {//neu gia tri node phia sau nho hoen hoac bang gia tri
            //node hien tai
            minIndex = current.getNext().getData();// gan gia tri nho nhat la gia tri node phia sau
        }
        return findMinIndex(minIndex,current.getNext());// thuc hien de quy
    }

    public void showList(){
        for(var node = head; node != null; node = node.getNext()){
            System.out.println(node.getData());
        }
    }

    public void showBinary(){
        for(var node = head;node != null; node = node.getNext()){
            System.out.print(node.getData());
        }
        System.out.println();
    }

    public void clear(){
        head = null;
    }

    public Node<T> search(T data){
        for(var node = head; node != null; node = node.getNext()){
            if(node.getData().equals(data)){
                return node;
            }
        }
        return null;
    }

    public void sortList(){
        Node<T> current = head;
        Node<T> index = null;

        while (current != null){
            index = current.getNext();
            while (index != null){
                if(current.getData().compareTo(index.getData()) > 0){
                    T temp = current.getData();
                    current.setData((index.getData()));
                    index.setData((temp));
                }
                index = index.getNext();
            }
            current = current.getNext();
        }
    }

    public void writeToFile(String fileName){
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for(var node = head; node != null; node = node.getNext()){
                bw.write(String.valueOf(node.getData()));
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (Exception e) {

        }
    }

    public boolean fileIsEmpty(String fileName){
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            return  line == null;
        }catch (Exception e){

        }
        return false;
    }

    public void resetFile(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();;
            fw.close();
        }catch (Exception e){

        }
    }

    public MyList<T> readFromFile(String fileName, MyList<T> list, boolean addLast){
        //Neu addLast = true thi them vao cuoi
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String txt[] = line.split("::");
                String bcode = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                Product newProduct = new Product(bcode,title,quantity,price);

                if (addLast){
                    list.insertTail((T)newProduct);
                }else {
                    list.insertHead((T)newProduct);
                }
            }
        }catch (Exception e){

        }
        return list;
    }
}
