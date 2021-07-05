package jucTest;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入锁：
 *
 */
class lockThread implements Runnable {

	@Override
	public void run() {
//		ReentrantLockTest.lockTest();//测试一
//		ReentrantLockTest.tryLockTest();//测试二（注：由于thread-0是先start的，所有该线程获取锁的几率大一些，但其他线程仍有机会先于它获到锁）
		ReentrantLockTest.tryLockTimeTest();//测试三
	}

}


public class ReentrantLockTest {

	private static Lock lock = new ReentrantLock();//true:公平策略 false:竞争策略（默认）

	public static void lockTest() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "：一直等待，直到获取锁成功!当前时间：" + System.currentTimeMillis());
		lock.unlock();
	}

	public static void tryLockTest() {
		if (lock.tryLock()) {
			try {
				System.out.println(Thread.currentThread().getName() + "：获取锁成功!当前时间：" + System.currentTimeMillis());
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "获取锁失败，立即返回!当前时间：" + System.currentTimeMillis());
		}
	}

	// lock.lockInterruptibly();//相当于tryLock(long time,TimeUnit unit) 把超时时间设置为无限(直到被中断），在等待锁的过程中，线程可以被中断
	public static void tryLockTimeTest() {
		try {
			if (lock.tryLock(1, TimeUnit.MICROSECONDS)) {
				try {
					System.out.println(Thread.currentThread().getName() + "在一段时间内，成功获取锁!当前时间：" + System.currentTimeMillis());
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "等待一段时间之后，获取锁失败！当前时间：" + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			System.out.println("-------------------"+Thread.currentThread().getName()+"中断抛出"+"-------------------");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		List<Thread> threadList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new lockThread(), "thread-" + i);
			threadList.add(thread);
			thread.start();
		}

		System.out.println("触发线程中断测试（只有测试三触发）");
		threadList.get(99).interrupt();
	}

}
