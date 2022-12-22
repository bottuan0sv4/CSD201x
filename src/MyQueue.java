import java.io.BufferedReader;
import java.io.FileReader;

public class MyQueue<T extends  Comparable<T>> {
    private int counter;
    private MyList<T> data;

    public MyQueue(){
        counter = 0;
        data = new MyList<>();
    }
    public void enQueue(T x){
        data.insertTail(x);
        counter++;
    }
    public void showQueue(){data.showList();}

    public void clearQueue(){
        data.clear();
    }

    public MyQueue<Product> readFile(String fileName){
        MyQueue<Product> queue = new MyQueue<>();
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


                queue.enQueue(newProduct);

            }
        }catch (Exception e){

        }
        return queue;
    }

}
