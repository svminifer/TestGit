package atomTest;


import java.util.HashMap;
import java.util.Map;


public class MapTest {

	public static void computeIfAbsentTest() {
		Map<Integer, String> map = new HashMap();

		map.put(1, "1");

		String s1 = map.computeIfAbsent(1, integer -> "1-1");

		System.out.println("键：1存在，返回值为键：1对应的key：1");
		System.out.println(s1);
		System.out.println(map.get(1));

		String s2 = map.computeIfAbsent(2, integer -> "2-2");

		System.out.println("键：2不存在，返回值为function函数的返回值");
		System.out.println(s2);
		System.out.println(map.get(2));

		map.put(3, "3");
		String s3 = map.computeIfAbsent(3, integer -> null);

		System.out.println("键：3存在，不会重新设置为null");
		System.out.println(s3);
		System.out.println(map.get(3));

		String s4 = map.computeIfAbsent(4, integer -> null);

		System.out.println("键：4不存在，重新设置为null");
		System.out.println(s4);
		System.out.println(map.get(4));
		System.out.println(map.containsKey(4));
	}

	public static void computeIfParentTest() {
		Map<Integer, String> map = new HashMap();

		map.put(1, "1");

		String s1 = map.computeIfPresent(1, (integer, string) -> "1-1");

		System.out.println("键：1存在，则设置新值：1-1");
		System.out.println(s1);
		System.out.println(map.get(1));

		String s2 = map.computeIfPresent(2, (integer, string) -> "2-2");

		System.out.println("键：2不存在，不会设置新值：2-2");
		System.out.println(s2);
		System.out.println(map.get(2));

		map.put(3, "3");
		String s3 = map.computeIfPresent(3, (integer, string) -> null);

		System.out.println("键：3存在，会重新设置为null");
		System.out.println(s3);
		System.out.println(map.get(3));

		String s4 = map.computeIfPresent(4, (integer, string) -> null);

		System.out.println("键：4不存在，则直接为null");
		System.out.println(s4);
		System.out.println(map.get(4));
		System.out.println(map.containsKey(4));
	}

	public static void main(String[] args) {

//		computeIfAbsentTest();
		computeIfParentTest();
	}

}
