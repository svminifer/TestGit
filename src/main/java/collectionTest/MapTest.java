package collectionTest;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MapTest {

	private static final Map<Long, Map<Integer, String>> queueConscription = new ConcurrentHashMap<>();

	public static void main(String[] args) {
//		HashMap<Integer, String> map = new HashMap<>();
//		map.put(1,"1");
//		queueConscription.put(1L,map);

//		HashMap<Integer, String> map = new HashMap<>();
//		map.put(2, "1");
//		queueConscription.put(1L, map);
//		booleanKeyTest(1L);

		booleanKeyTestByType();
	}

	public static void booleanKeyTest(Long roleId){
		System.out.println(queueConscription.containsKey(roleId));
		if (queueConscription.containsKey(roleId) && queueConscription.get(roleId).containsKey(1)){
			System.out.println(1);
			return;
		}
		System.out.println(2);
	}

	public static void booleanKeyTestByType(){
		HashMap<Long, String> map = new HashMap<>();
		map.put(1L,"100");
		map.put(2L,"200");
		map.put(3L,"300");

		long val=1L;

		 System.out.println(map.containsKey(val));
		 System.out.println(map.get(val));
	}


}
