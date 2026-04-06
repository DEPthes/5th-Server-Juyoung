package week1;

public class OverLoadingTest {
    public static void main(String[] args){
        //오버라이딩이랑 오버로딩이랑 이름이 헷갈려서 공부하는 김에
        System.out.println(mult(1,2));
        System.out.println(mult(1,2,3));
    }
    public static int mult(int a, int b){
        return a*b;
    }
    public static int mult(int a, int b, int c){
        return a*b*c;
    }
}
