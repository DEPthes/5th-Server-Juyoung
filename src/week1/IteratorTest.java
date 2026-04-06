package week1;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    
    public static void main(String[] args){
        ArrayList<String>list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
