package reflectionTest.object;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Value {
    String value() default "this is a humnan";

    TypeEnum sex() default TypeEnum.BOY;
}
