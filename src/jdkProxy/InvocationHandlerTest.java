package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class InvocationHandlerTest implements InvocationHandler{

    private final Object target;

    public InvocationHandlerTest(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前：" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("执行方法之后：" + method.getName());
        return result;
    }
}
