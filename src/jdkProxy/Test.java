package jdkProxy;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class Test {
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsService proxy = (SmsService)JDKProxyFactory.getProxy(smsService);
        proxy.send("你好");


    }
}
