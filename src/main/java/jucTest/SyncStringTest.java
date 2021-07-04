package jucTest;


class Player {

	private int id;

	private String name;

	public Player() {
	}

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


class MyThread implements Runnable {

	private String playerName;

	public MyThread() {
	}

	public MyThread(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public void run() {
		SyncStringTest.syncTest(playerName);
	}

}


/**
 * 可重入锁：（悲观锁、阻塞锁）
 * 锁住字符串：
 * 若是编译期（字符串直接赋值，String name = "zhangsan")：
 * 		则一般来说都能锁住对象
 *
 * 运行期（String name = new String("name")：
 * 		则一般来说需要使用name.intern()，获取字符串常量池中的引用才能锁住对象
 *
 * 锁住Integer:
 *
 * 只能锁住-128到127的值，这些值会在常量池中获取，其他值会直接new
 */
public class SyncStringTest {

	public static void main(String[] args) {
		//第一种情况
		Player player1 = new Player(1, new String("zhangsan"));
		Player player2 = new Player(2, new String("zhangsan"));


		//第二种情况
//		Player player1 = new Player(1, "zhangsan");
//		Player player2 = new Player(2, "zhangsan");

		new Thread(new MyThread(player1.getName())).start();
		new Thread(new MyThread(player2.getName())).start();

	}

	public static void syncTest(String playerName) {
		System.out.println("inter!");

//		synchronized (playerName.intern()){ //情況一（解决）：可以锁住对象
		synchronized (playerName) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(System.identityHashCode(playerName));
		}
	}

}
