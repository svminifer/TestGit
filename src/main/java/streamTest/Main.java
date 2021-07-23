package streamTest;


import enumTest.playerTest.Player;
import org.junit.jupiter.api.Test;

import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * refer https://blog.csdn.net/sihai12345/article/details/109685026
 */
public class Main {

	private static Map<String, Player> playerMap;

	private static Map<String, Player> otherPlayerMap;

	private static List<Player> playerList;

	private static List<Player> otherPlayerList;

	static {
		init();
	}

	/**
	 * 模拟加载数据到应用级缓存
	 */
	private static void init() {
		playerMap = new ConcurrentHashMap<>();
		otherPlayerMap = new ConcurrentHashMap<>();

		playerMap.put("1", new Player(1, "liyi", (long) (Math.random() * 100000)));
		playerMap.put("2", new Player(2, "wanger", (long) (Math.random() * 100000)));
		playerMap.put("3", new Player(3, "zhangsan", (long) (Math.random() * 100000)));
		playerMap.put("4", new Player(4, "lisi", (long) (Math.random() * 100000)));

		otherPlayerMap.put("5", new Player(5, "liyi5", (long) (Math.random() * 100000)));
		otherPlayerMap.put("6", new Player(6, "wanger6", (long) (Math.random() * 100000)));
		otherPlayerMap.put("7", new Player(7, "zhangsan7", (long) (Math.random() * 100000)));
		otherPlayerMap.put("8", new Player(8, "lisi8", (long) (Math.random() * 100000)));

		playerList = new Vector<>();
		otherPlayerList = new Vector<>();

		playerList.add(new Player(1, "liyi", (long) (Math.random() * 100000)));
		playerList.add(new Player(2, "wanger", (long) (Math.random() * 100000)));
		playerList.add(new Player(3, "zhangsan", (long) (Math.random() * 100000)));
		playerList.add(new Player(4, "lisi", (long) (Math.random() * 100000)));

		otherPlayerList.add(new Player(5, "liyi5", (long) (Math.random() * 100000)));
		otherPlayerList.add(new Player(6, "wanger6", (long) (Math.random() * 100000)));
		otherPlayerList.add(new Player(7, "zhangsan7", (long) (Math.random() * 100000)));
		otherPlayerList.add(new Player(8, "lisi8", (long) (Math.random() * 100000)));
	}

	public static void main(String[] args) {

//		boolean zhangsan = playerMap.entrySet().stream().noneMatch(stringPlayerEntry -> stringPlayerEntry.getValue().getName().equals("zhangsan") && stringPlayerEntry.getValue().getId() == 4);
//
//		System.out.println(zhangsan);

	}

	/**
	 * map转list
	 */

	@Test
	public void mapToList() {
		List<Player> players = playerMap.values().stream().collect(Collectors.toList());
		players.forEach(System.out::println);
	}

	@Test
	public void listToMap() {
		Map<Long, Player> players = playerList.stream().collect(Collectors.toMap(Player::getId, player -> player));
		players.forEach((id, player) -> System.out.println(id + " : " + player));
	}

	@Test
	public void mergeMapEg1() {
		Map<String, Player> map1 = new HashMap<String, Player>();
		Player player1 = new Player();
		player1.setId(1);
		player1.setName("小明");
		Player player2 = new Player();
		player2.setId(1);
		player2.setName("小张");

		map1.put("小明", player1);
		map1.put(player2.getName(), player2);

		Map<String, Player> map2 = new HashMap<String, Player>();
		Player player3 = new Player();
		player3.setId(2);
		player3.setName("小明");
		Player player4 = new Player();
		player4.setId(1);
		player4.setName("小强");

		map2.put(player3.getName(), player3);
		map2.put(player4.getName(), player4);

		// key一样，取id较大
		Map<String, Player> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> {
			Player player = new Player();
			long age = value2.getId();
			if (value1.getId() >= value2.getId()) {
				age = value1.getId();
			}
			player.setName(value1.getName());
			player.setId(age);
			return player;
		}));

		result.forEach((s, player) -> System.out.println(s));
	}

	/**
	 * ————————————————
	 * 版权声明：本文为CSDN博主「_函数_」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
	 * 原文链接：https://blog.csdn.net/suolongdse/article/details/108325976
	 */
	@Test
	public void mergeMapEg2() {
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
		List<Map<String, Object>> combine = sourceList.stream()
				// 根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
				.collect(Collectors.groupingBy(group -> group.get("id").toString()))
				// 得到Set<Map.Entry<String, List<Map<String, Object>>>
				.entrySet().stream()
				// 进入映射环境
				.map(m -> {
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

	/**
	 * https://www.jb51.net/article/194704.htm
	 * eg3 - eg4
	 */
	@Test
	public void mergeMapEg3() {
		//  (player1, player2) -> player1 表示两者相等取player1
		otherPlayerMap.forEach((s, player) -> playerMap.merge(s, player, (player1, player2) -> player1));
		System.out.println(playerMap.size());
	}

	@Test
	public void mergeMapEg4() {
		Map<String, Player> collect = Stream.concat(playerMap.entrySet().stream(), otherPlayerMap.entrySet().stream())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1));
		collect.forEach((s, player) -> System.out.println(s + " : " + player));
		// map转换成key不同的map
		Map<Long, Player> otherCollect = collect.values().stream().collect(Collectors.toMap(Player::getIdCard, p -> p));
		otherCollect.forEach((s, player) -> System.out.println(s + " : " + player));
	}

	/**
	 * stream流 求和
	 */
	@Test
	public void streamCount() {
		List<Player> list = new ArrayList<>();
		double max = list.stream().mapToDouble(Player::getId).sum();
	}

}

