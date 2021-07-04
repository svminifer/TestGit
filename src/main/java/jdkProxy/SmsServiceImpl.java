package jdkProxy;

/**
 * @Author kaboso
 * @Date 2021/3/25
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("输出信息："+message);
        return message;
    }
}
