package week1;

public class AbstractTest {
    public static void main(String[] args){
        Square s = new Square(10);
        System.out.println(s.calculateArea());
        Circle c = new Circle(3);
        System.out.println(c.calculateArea());
    }
}
abstract class Shape{
    abstract double calculateArea();
}
class Square extends Shape{
    double s;
    Square(double s){
        this.s = s;
    }
    double calculateArea(){
        return s*s;
    }
}
class Circle extends Shape{
    double r;
    Circle(double r){
        this.r = r;
    }
    double calculateArea(){
        return Math.PI *r *r;
    }

}
