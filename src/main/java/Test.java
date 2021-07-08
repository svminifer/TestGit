import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 查看源碼
 */
public class Test {

	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		Vector<Object> vector = new Vector<>();
		LinkedList<Object> linkedList = new LinkedList<>();

		HashSet<Object> hashSet = new HashSet<>();
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		TreeSet<Object> treeSet = new TreeSet<>();

		new HashMap<>();
		new Hashtable<>();
		new ConcurrentHashMap<>();

		Double aDouble = new Double(1.0);

        Double dfdf = null;

        HashMap<Integer, String> map = new HashMap<>();

        Integer integer = new Integer(122222);
        int ints = 122222;
        map.put(integer, "1");
        map.put(122222, "2");
        map.put(ints, "3");

        System.out.println("测试新 user");


    }

}
