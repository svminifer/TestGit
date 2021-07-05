package extend;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        {
            System.out.println(123);
        }
        Son son = new Son();
        System.out.println();
        System.out.println("第二次创建：");
        Son son1 = new Son();

        Class<?> son2 = Class.forName("extend.Son");
        Son o = (Son) son2.newInstance();
        int a;
        Integer val=1233245324;
        val=val.hashCode()^ val>>>16;
        System.out.println(val);

    }

    //只有调用时才会加载
    static class StaticClassTest{
        static {
            System.out.println("静态内部类");
        }
    }
}
