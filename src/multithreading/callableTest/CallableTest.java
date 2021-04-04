package multithreading.callableTest;

import java.util.concurrent.*;

/**
 * @Author kaboso
 * @Date 2021/4/1
 */
public class CallableTest {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        FutureTask<Boolean> task1 = new FutureTask<Boolean>(myThread1);
        FutureTask<Boolean> task2 = new FutureTask<Boolean>(myThread2);
        Thread thread = new Thread(task1);
        thread.start();
        try {
            System.out.println(task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }
}
