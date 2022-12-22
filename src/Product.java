import java.util.Objects;

public class Product implements  Comparable<Product> {
    private String bcode;
    private String title;
    private int quantity;
    private double price;

    public Product(String bcode, String title, int quantity, double price){
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String bcode){
        this.bcode = bcode;
    }

    public Product(){

    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return bcode + "::" + title + "::" + quantity + "::" + price;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) {return true;}
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Product product = (Product) o;
        return bcode.equals(product.bcode);
    }

    @Override
    public int hashCode(){return Objects.hash(bcode);}

    @Override
    public int compareTo(Product o){
        return this.bcode.compareTo(o.bcode);
    }

    //Phuong thuc chuyen doi gia tri thap phan thanh so nhi phan
    public int covertToBinary(int x, MyStack<String> binary){
        binary.push(String.valueOf(x % 2));// day vao stack gia tri du cua phep chia x cho 2
        if(x == 1){// Neu x == 1 thi tra ve 1 va ket thuc de quy
            return 1;
        }else {//Nee x != 1 thi tiep tuc de quy bang cach truyen vao thuong cua phep chia x cho 2
            return covertToBinary(x/2, binary);
        }
    }
}
