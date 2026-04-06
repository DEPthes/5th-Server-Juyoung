package week1;

public class StringMethodTest {
    public static void main(String[] args){
        //앞으로 문자 받아서 처리 할게 많으면 필요하지 않을까
        String s = "Do u like Java";
        System.out.println(s.startsWith("Do u"));
        System.out.println(s.endsWith("Java"));
        s=s.replace("like", "dislike");
        s=s.concat("?");
        System.out.println(s);

    }
}
