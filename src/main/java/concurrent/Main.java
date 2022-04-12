package concurrent;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;


public class Main {

	public static void main(String[] args) {
		threadSynBlocking();
	}

	/**
	 * 多线程同步阻塞实现方式
	 */
	public static boolean threadSynBlocking() {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		AtomicBoolean res = new AtomicBoolean(false);
		try {
			new Thread(() -> {
				try {
					System.out.println("wait 10000 ms");
					System.out.println("time：" + System.currentTimeMillis());
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					countDownLatch.countDown();
				}
			}).start();
			countDownLatch.await();
			System.out.println("time：" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			countDownLatch.countDown();
			System.out.println(countDownLatch.getCount());
		}
		return res.get();
	}

}
