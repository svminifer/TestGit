import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello github!");

        List<String> list=new ArrayList();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if(Objects.equals("2",item)){
                iterator.remove();
            }
        }

        for (String item: list) {
            if ("1".equals(item)){
                list.remove(item);
            }

        }

        System.out.println(list);
    }
}
