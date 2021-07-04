package api.CollectionsTest;

import java.util.HashMap;

/**
 * @Author kaboso
 * @Date 2021/3/31
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("1","11");
        map.put("2","12");
        map.put("3","13");
        map.put("4","14");

        map.remove("3");
        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });



        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }
}
