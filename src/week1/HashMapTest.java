package week1;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //HashSet과 달리 add가 아닌 put
        map.put("철수",10);
        map.put("영희",20);
        map.put("철수",100);
        for (int i:map.values()){
            System.out.println(i);
        }
        
    }
}
