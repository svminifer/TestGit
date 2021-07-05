package jdkProxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target){
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandlerTest(target));

        return o;
    }
}
