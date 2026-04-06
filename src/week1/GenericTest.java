package week1;

public class GenericTest {
    public static void main(String[] args){
        Box<Integer> ibox = new Box<>();
        ibox.setData(10);
        System.out.println(ibox.data);
        Box<String> sbox = new Box<>();
        sbox.setData("hello");
        System.out.println(sbox.data);
    }
}
class Box<T>{
    T data;
    public void setData(T data){
        this.data=data;
    }
}