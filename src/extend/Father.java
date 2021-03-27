package extend;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class Father {


    public Father(){
        System.out.println("父类构造方法");
    }
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类非静态代码块");
    }
}
