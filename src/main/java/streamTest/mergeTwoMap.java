package streamTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// java stream 两个List＜Map＞合并
public class mergeTwoMap {

	public static void main(String[] args) {
		// ============== new三条源数据，value值均为一个字，加入list ==================
		Map<String, Object> map1 = new HashMap<>();
		map1.put("id", "1");
		map1.put("ab", "甲");
		map1.put("ac", "乙");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("id", "2");
		map2.put("ab", "丙");
		map2.put("ac", "丁");
		Map<String, Object> map3 = new HashMap<>();
		map3.put("id", "3");
		map3.put("ab", "小果");
		map3.put("ac", "相机");

		List<Map<String, Object>> sourceList = new ArrayList<>();
		sourceList.add(map1);
		sourceList.add(map2);
		sourceList.add(map3);

		// ============== new三条新带并入的数据，value值均为两个字，加入list ==================
		Map<String, Object> newMap1 = new HashMap<>();
		newMap1.put("id", "1");
		newMap1.put("ww", "小强");
		newMap1.put("nn", "小张");
		Map<String, Object> newMap2 = new HashMap<>();
		newMap2.put("id", "2");
		newMap2.put("ww", "王红");
		newMap2.put("nn", "王亮");
		Map<String, Object> newMap3 = new HashMap<>();
		newMap3.put("id", "3");
		newMap3.put("ww", "朱大");
		newMap3.put("nn", "朱二");

		List<Map<String, Object>> newList = new ArrayList<>();
		newList.add(newMap1);
		newList.add(newMap2);
		newList.add(newMap3);

		// ============ 把newList的所有内容添加到sourceList中 ==============
		sourceList.addAll(newList);

		sourceList.forEach(System.out::println);
		System.out.println();

        /*
         输出结果：
            {ab=甲, ac=乙, id=1}
            {ab=丙, ac=丁, id=2}
            {ab=小果, ac=相机, id=3}
            {ww=小强, nn=小张, id=1}
            {ww=王红, nn=王亮, id=2}
            {ww=朱大, nn=朱二, id=3}

         我们要求合并后的结果：
            {nn=小张, ww=小强, ab=甲, ac=乙, id=1}
            {nn=王亮, ww=王红, ab=丙, ac=丁, id=2}
            {nn=朱二, ww=朱大, ab=小果, ac=相机, id=3}
         */


		// ================ 利用Java8的Stream流实现合并 =========================
		List<Map<String,Object>> combine = sourceList.stream()
				.collect(Collectors.groupingBy(group -> group.get("id").toString())) // 根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
				.entrySet() // 得到Set<Map.Entry<String, List<Map<String, Object>>>
				.stream() // 使用Java8的流
				.map(m -> { // 进入映射环境
					// m.getValue()的结果是 List<Map<String, Object>>
					Map<String, Object> collect = m.getValue().stream()
							// o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
							.flatMap(o -> o.entrySet().stream())
							// (m1, m2) -> m2 的意思是如果 m1 == m2 则使用m2
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m2));
					return collect;
				}).collect(Collectors.toList());

		// 输出测试，
		combine.forEach(System.err::println);

        /*
          测试结果：
             {nn=小张, ww=小强, ab=甲, ac=乙, id=1}
             {nn=王亮, ww=王红, ab=丙, ac=丁, id=2}
             {nn=朱二, ww=朱大, ab=小果, ac=相机, id=3}

          达到目标要求(●'◡'●)
         */

	}

}


//public class CompletableFutureTest {
//
//
//	public static void main(String[] args) {
//		Map<String, Employee> map1 = new HashMap<String, Employee>();
//		Employee employee1 = new Employee();
//		employee1.setAge(1);
//		employee1.setName("小明");
//
//		Employee employee2 = new Employee();
//		employee2.setAge(1);
//		employee2.setName("小张");
//
//		map1.put("小明", employee1);
//		map1.put(employee2.getName(), employee2);
//
//
//		Map<String, Employee> map2 = new HashMap<String, Employee>();
//		Employee employee3 = new Employee();
//		employee3.setAge(2);
//		employee3.setName("小明");
//
//		Employee employee4 = new Employee();
//		employee4.setAge(1);
//		employee4.setName("小强");
//
//		map2.put(employee3.getName(), employee3);
//		map2.put(employee4.getName(), employee4);
//
//		Map<String, Employee> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
//				.collect(Collectors.toMap(
//						Map.Entry::getKey,
//						Map.Entry::getValue,
//						(value1, value2) ->{
//
//							Employee employee = new Employee();
//							int age = value2.getAge();
//							if(value1.getAge()>=value2.getAge()){
//								age = value1.getAge();
//							}
//							employee.setName(value1.getName());
//							employee.setAge(age);
//
//							return employee;
//						}
//				));
//
//
//		System.out.println(JSON.toJSONString(result));
//
//
//	}
//}
