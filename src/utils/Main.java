import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;


public class Main {

	public static void main(String[] args) {
//		Player player = new Player();
//		player.setId(1);
//		player.setMailboxId(1);
//		player.setPhone("1324679101");
//		player.setName("zhangsan");
//		player.setSex(1);
//
//		HashMap<Integer, String> map = new HashMap<>();
//		String s = map.get(1);
//		System.out.println(s);
//
//		HashMap<Integer, List<Integer>> listHashMap = new HashMap<>();
//
//		List<Integer> list = new LinkedList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//
//		listHashMap.put(1, list);
//
//		List<Integer> integerList = listHashMap.get(1);
//
//		integerList.remove(0);
//
//		List<Integer> integers = listHashMap.get(1);
//
//		System.out.println(integers.size());
//
//		// 初始化AtomicStampedReference对象，值为5，版本号为1
//		AtomicStampedReference<Map<Integer, List<Integer>>> atomicMap = new AtomicStampedReference<Map<Integer, List<Integer>>>(listHashMap, 1);

		// 初始化AtomicStampedReference对象，值为5，版本号为1
//		AtomicStampedReference<Integer> atomic = new AtomicStampedReference<Integer>(5, 1);
//
//		new Thread(() -> {
//			int stamp = atomic.getStamp();
//			System.out.println(Thread.currentThread().getName() + "初始版本号：" + stamp);
//			//Sleep 1s
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			//先从5改成10
//			atomic.compareAndSet(5, 10, atomic.getStamp(), atomic.getStamp() + 1);
//			//再从10改成5
//			atomic.compareAndSet(10, 5, atomic.getStamp(), atomic.getStamp() + 1);
//			//输出结果，这时值为5，版本号为3
//			System.out.println(Thread.currentThread().getName() + "当前值：" + atomic.getReference() + "，当前版本号：" + atomic.getStamp());
//		}, "thread-1").start();
//
//		new Thread(() -> {
//			int stamp = atomic.getStamp();
//			System.out.println(Thread.currentThread().getName() + "初始版本号：" + stamp);
//			//Sleep 3s，保证thread-1先执行完毕，到时版本号会更高
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			//预期将值从5改成100，预期版本号是1
//			boolean result = atomic.compareAndSet(5, 100, stamp, stamp + 1);
//			System.out.println(Thread.currentThread().getName() + "修改状态：" + result + "，当前值：" + atomic.getReference() + "，当前版本号：" + atomic.getStamp());
//		}, "thread-2").start();

//		System.out.println((int)((Math.random()*9+1)*100000));

//		String a = "hello";
//		String b = "hello";
//
//		System.out.println(a.getBytes().length);
//		System.out.println(b.getBytes().length);

		System.out.println((int)(Double.valueOf("0.1") * 1.0));
		System.out.println((int)(Double.parseDouble("0.1") * 1.0));
	}

}
