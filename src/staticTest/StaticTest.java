package staticTest;

import java.util.*;

/**
 * @Author kaboso
 * @Date 2021/3/30
 */

/**
 * 静态类只能用于静态内部类
 */
// 这种写法无法通过
//static class OutStatic{
//
//}
public  class StaticTest{
    static class MyStatic{

    }
    public static void main(String[] args) {
        Integer integer=new Integer(1);

        Set sets = new HashSet();

        sets.add(null);
        sets.add(null);
        HashMap<String, String> map = new HashMap<>();
        map.put("string","str");
        System.out.println(map.size());
        HashMap<String, String> stringStringHashMap = new HashMap<>(14);
        stringStringHashMap.put("s","s");





        Iterator iterator = sets.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

}


