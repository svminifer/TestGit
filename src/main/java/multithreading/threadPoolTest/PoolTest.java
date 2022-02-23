package multithreading.threadPoolTest;

import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kaboso
 * @Date 2021/4/1
 */
public class PoolTest {

    class Test{
        private final Integer a=123;

    }

    /**
     * 用于为线程池命名
     *
     */
    static class NameTheadFactory implements ThreadFactory{
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NameTheadFactory() {
            //默认namePrefix = default-name-pool
            this("default-name-pool");
        }

        NameTheadFactory(String name){
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            //此时namePrefix就是 name + 第几个用这个工厂创建线程池的
            this.namePrefix = name +
                    poolNumber.getAndIncrement();
        }

        public Thread newThread(Runnable r) {
            //此时线程的名字 就是 namePrefix + -thread- + 这个线程池中第几个执行的线程
            Thread t = new Thread(group, r,
                    namePrefix + "-thread-"+threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    //

    /**
     *  实例化静态内部类，该类用于简陋的监控当前线程池的活跃线程数，
     *  但由于线程调度是抢占式的，因此不一定能在控制台实时看到对应的信息，
     *  有时候没抢到CPU执行时间片，可能得等线程池的所有任务执行完，才有机会进行
     */
    static class MonitorThread implements Runnable{

        private ThreadPoolExecutor executor;
        public MonitorThread(ThreadPoolExecutor executor) {
            this.executor=executor;
        }
        @Override
        public void run() {
            System.out.println("==="+executor.isShutdown());
            while(!executor.isShutdown()){
                System.out.println("当前活跃线程数："+executor.getActiveCount()+" 线程池状态："+executor.isShutdown());
                if (executor.getActiveCount() == 1) return;
            }
        }
    }
    public static void main(String[] args) {
        //拒绝策略：main执行任务
        mainTOHandler();
        //单例线程
        Executors.newSingleThreadExecutor();

    }


    /**
     * 模拟阻塞队列满了之后，实现拒绝策略：调用execute方法的线程执行任务（本例中为main方法）
     *
     * 线程池
     *  核心数     5
     *  最大数     6
     *  存活时间    10
     *  单位        s
     *  阻塞队列    数组 容量为1
     *  拒绝策略    CallerRunsPolicy在任务被拒绝添加后，会在调用execute方法的的线程来执行被拒绝的任务
     */
    public static void mainTOHandler() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),new NameTheadFactory("TestMain!!!!-"), new ThreadPoolExecutor.CallerRunsPolicy());

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(5, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),new NameTheadFactory("TestMain!!!!-"), new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 500; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        long time=(long) (Math.random()*1000);
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName()+" date:"+ Instant.now()+" "+time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            executor2.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        long time=(long) (Math.random()*1000);
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName()+" date:"+ Instant.now()+" "+time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        MonitorThread monitorThread = new MonitorThread(executor);
        Thread thread = new Thread(monitorThread);
        thread.setPriority(10);


        executor.execute(thread);






        //关闭线程池
        executor.shutdown();



        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
