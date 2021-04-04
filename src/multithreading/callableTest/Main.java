package multithreading.callableTest;

/**
 * @Author kaboso
 * @Date 2021/4/1
 */

/**
 * 状态：新建、可运行（就绪、运行中）、阻塞等待、时间等待、死亡
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinB(),"joinB-1");
        thread.start();
        Thread thread1 = new Thread(new JoinA(thread));
        thread1.start();

        Thread.State state = thread.getState();
        while(state !=Thread.State.TERMINATED){
            state=thread.getState();
            System.out.println(state);
        }


        System.out.println("主线程");

    }
}

class JoinA implements Runnable{

    private Thread thread;

    public JoinA(){}

    public JoinA(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            System.out.println("JoinA: 休眠，让"+thread.getName());
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JoinA唤醒：继续执行");
    }
}

class JoinB implements Runnable{


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"执行完毕！");

    }
}
