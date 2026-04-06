package week1;

public class OverridingTest {
    public static void main(String[] args){
        //다향성
        Person s= new Student();
        s.setRegion("수원");
        s.introduce();
        s=new Student(){
            @Override
            public void introduce(){
                System.out.println("익명");
            }
        };
        s.introduce();
    }
    //inner class
    private static class Student extends Person{
        int id;
        //final은 overriding불가
        public void introduce(){
            System.out.printf("저는 학생이고 %s에 거주 중입니다\n",getRegion());
        }
    }
}
