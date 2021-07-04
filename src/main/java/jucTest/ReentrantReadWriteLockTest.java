package jucTest;


import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 读写锁：
 * 		读读不冲突
 * 		读写冲突
 * 		写写冲突
 */
public class ReentrantReadWriteLockTest {
	private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	private static ReentrantReadWriteLock.ReadLock readLock=reentrantReadWriteLock.readLock();

	private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

	private static void read() {
		readLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + "释放了读锁");
			readLock.unlock();
		}
	}

	private static void write(){
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + "释放了写锁");
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		new Thread(()-> read(),"read-thrad-1").start();
		new Thread(()-> read(),"read-thrad-2").start();
		new Thread(()-> write(),"write-thrad-1").start();
		new Thread(()-> write(),"write-thrad-2").start();
	}
}
