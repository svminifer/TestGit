package multithreading.callableTest;

import java.util.concurrent.Callable;

/**
 * @Author kaboso
 * @Date 2021/4/1
 */
public class MyThread implements Callable {
    @Override
    public Boolean call() throws Exception {
        Thread.sleep(10000);
        System.out.println("结束！");
        return true;

    }
}
