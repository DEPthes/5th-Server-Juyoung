package week1;

public class LamdaInterfaceTest {
    public static void main(String[] args) {
        Calculator add = (x,y)->x+y;
        int result = add.calculate(4, 5);
        System.out.println(result);
        Calculator sub = (x,y)->x-y;
        result = sub.calculate(4, 5);
        System.out.println(result);
        
    }
    @FunctionalInterface
    public interface  Calculator {
        int calculate(int x, int y);
        
    }
}
