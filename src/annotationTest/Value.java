package annotationTest;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value() default "default";

    String name() default "name";
}
