import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class MyStack<T extends  Comparable<T>> {
    private int counter;
    private MyList<T> data;

    public MyStack(){
        counter = 0;
        data = new MyList<>();
    }

    public boolean isEmpty(){return data.isEmpty();}

    public void push(T x){
        data.insertHead(x);
        counter++;
    }

    public void pop(){
        data.removeNode((data.front().getData()));
        counter--;
    }
    public void showStackOfBinary(){data.showBinary();}

    public void showStack(){data.showList();}

    public void clearStack(){
        data.clear();
    }

    public MyStack<Product> readFile(String fileName){
        MyStack<Product> stack = new MyStack<>();
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


                stack.push(newProduct);

            }
        }catch (Exception e){

        }
        return stack;
    }

}
