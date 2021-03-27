package extend;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class Son extends Father {

    public Son(){
        System.out.println("子类构造方法");
    }
    private int i;
    static {
        int i=0;
//        System.out.println(i);可以进行赋值，但不能访问，编译报错
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }
}
