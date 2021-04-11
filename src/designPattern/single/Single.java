package designPattern.single;

/**
 * 饿汉模式
 * @Author kaboso
 * @Date 2021/4/4
 */
public class Single {

    private volatile static Single instance;
    private Single(){}

//    private static Single instance =new Single; //1.线程安全的饿汉模式
    /**
     * 2.线程安全的懒汉模式
     * @return
     */
    public synchronized Single getLazyInstance(){
        if (instance == null) {
            instance=new Single();
        }
        return instance;
    }

    /**
     * 3.双重校验锁
     * @return
     */
    public Single getDoubleInstance(){
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance=new Single();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类获取
     */
    static class StaticSingle{
        private final static Single instances=new Single();
        public static Single getInstance(){
            return instances;
        }
    }


}
