package streamTest;


import enumTest.playerTest.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class Main {

	private static Map<String, Player> playerMap;

	/**
	 * 模拟加载数据到应用级缓存
	 */
	private static void init() {
		playerMap = new ConcurrentHashMap<>();

		playerMap.put("1", new Player(1, "liyi"));
		playerMap.put("2", new Player(2, "wanger"));
		playerMap.put("3", new Player(3, "zhangsan"));
		playerMap.put("4", new Player(4, "lisi"));
	}

	public static void main(String[] args) {
		init();
		MapToList();


//		boolean zhangsan = playerMap.entrySet().stream().noneMatch(stringPlayerEntry -> stringPlayerEntry.getValue().getName().equals("zhangsan") && stringPlayerEntry.getValue().getId() == 4);
//
//		System.out.println(zhangsan);




	}

	public static void MapToList(){
		List<Player> players = playerMap.values().stream().collect(Collectors.toList());

		System.out.println(Arrays.toString(players.toArray()));
	}

}
