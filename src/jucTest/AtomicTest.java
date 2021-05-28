package jucTest;


import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicReference;


/**
 * 自旋锁（CAS）：
 *
 */
public class AtomicTest {

	private AtomicReference<Thread> sign = new AtomicReference<>();

	public void lock(){
		Thread currentThread = Thread.currentThread();
		while (!sign.compareAndSet(null,currentThread)){
			System.out.println("自旋获取失败，再次尝试");
		}
	}

	public void unLock(){
		Thread currentThread = Thread.currentThread();
		sign.compareAndSet(currentThread,null);
	}

	public static void main(String[] args) {
		AtomicTest atomicTest = new AtomicTest();
		Runnable runnable = new Runnable(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName()+"开始尝试自旋锁");
				atomicTest.lock();
				System.out.println(Thread.currentThread().getName()+"获取到了自旋锁");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					atomicTest.unLock();
					System.out.println(Thread.currentThread().getName()+"释放了自旋锁");
				}
			}
		};

		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
	}
}
