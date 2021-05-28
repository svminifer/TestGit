package annotationTest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;

/**
 * @Target 目标
 * @Retention 保留  不写默认为CLASS
 * @Document 文档
 * @Inherited 继承
 */
public class Main {

    @Value(value="1234",name="张三")
    public void test() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            Value method = main.getClass().getMethod("test").getAnnotation(Value.class);

            System.out.println(method.value());
            System.out.println(method.name());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
