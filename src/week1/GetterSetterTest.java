package week1;

public class GetterSetterTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setRegion("seoul");
        System.out.println(p.getRegion());

    }

}
//outer class
class Person{
    //Getter랑 Setter습관이나 들이자
    //public으로 인스턴스 변수보단 보안상으로 이게 더 좋으니깐
    String region;
    public String getRegion(){
        return region;
    }
    public void setRegion(String region){
        this.region=region;
    }
    public void introduce(){
        System.out.printf("저는 %s에 거주합니다",getRegion());
    }
}

