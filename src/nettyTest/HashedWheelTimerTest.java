package nettyTest;


import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 超时任务执行
 * 也可以理解为定时任务
 */
public class HashedWheelTimerTest {

	public static void main(String[] args) throws InterruptedException {
		// 默认线程工厂（用于创建线程），每格时间间隔（默认100），时间单位，轮子大小（一圈多少格）
		HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(Executors.defaultThreadFactory(), 10000, TimeUnit.MILLISECONDS, 32);

		hashedWheelTimer.newTimeout(new TimerTask() {
			@Override
			public void run(Timeout timeout) throws Exception {
				System.out.println("shiganyao");
			}
		}, 1000, TimeUnit.MILLISECONDS);

		Thread.sleep(1000);
	}

}
