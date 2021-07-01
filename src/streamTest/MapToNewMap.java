package streamTest;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 旧的map转换成自定义k,v的map
 * https://www.cnblogs.com/StarChen20/p/14005122.html
 *
 */
public class MapToNewMap {

	static class Student {//只是为了方便演示

		private Integer id;

		private String name;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Student(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

	}

	public static void main(String[] args) {

		//测试数据，实际中map可能来自数据库或其他方。
		Map<String, Object> map = new HashMap<>();
		map.put("a", new Student(1, "张三"));
		map.put("b", new Student(2, "李四"));
		map.put("c", new Student(3, "王五"));
		map.put("d", new Student(4, "赵六"));

		//需求是将Map<String,Object>改为Map<String,Object.字段>
		Map<String, Object> collect = map.entrySet()//获取集合
				.stream()//获取流
				.peek(obj -> obj.setValue(((Student) obj.getValue()).getName()))//peek支持在每个元素上执行一个操作并且返回新的stream
				// ，我们就利用这个方法转换数据
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));//collect方法用来将流转到集合对象

		//遍历输出
		collect.forEach((key, value) -> System.out.println(key + "：" + value));

	}

}
