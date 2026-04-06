package week1;

import java.io.FileWriter;

public class ExceptionTest {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("file.txt")){
            writer.write("안녕");
        }catch(Exception e){
            System.out.println("문제 발생");
        }
        try{
            int age = -5;
            if( age<0){
                throw new MyException("나이는 음수일 수 없음");
            }
        }catch(MyException e){
            System.out.println("문제발생: "+e.getMessage());
        }
    }
    static int divide(int a, int b) throws Exception{
        return a/b;
    }

}
class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }
}
