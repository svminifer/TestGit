package reflectionTest;


import lombok.SneakyThrows;
import reflectionTest.object.Father;
import reflectionTest.object.Son;
import reflectionTest.object.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionTest {
    @SneakyThrows
    public static void main(String[] args) {
        // 1.获取Class类
        Father father = new Father();
        Class<? extends Father> fatherClass = father.getClass();
        Class<? extends Class> fatherClassClass = fatherClass.getClass();
        Class<?> superclass = fatherClass.getSuperclass();
        Object[] signers = fatherClass.getSigners(); // 类加载有关，有兴趣可以详细去了解
        // 2.获取Class类名
        String name = fatherClass.getName();
        String simpleName = fatherClass.getSimpleName();
        String canonicalName = fatherClass.getCanonicalName();
        String typeName = fatherClass.getTypeName();
        // 3.包含父类方法
        Method[] methods = fatherClass.getMethods();
        // 4.只包含声明方法
        Method[] declaredMethods = fatherClass.getDeclaredMethods();
        Method enclosingMethod = fatherClass.getEnclosingMethod();
        // 使用getMethod会同时获取父类的方法，此外，会检查修饰符，子类的private修饰的方法不会被找到
        // Method hobby = fatherClass.getMethod("hobby", String.class);
        Method hobby = fatherClass.getDeclaredMethod("hobby", String.class);
        String hobbyName = hobby.getName();
        Annotation[] hobbyAnnotations = hobby.getAnnotations();
        Annotation[] hobbyDeclaredAnnotations = hobby.getDeclaredAnnotations();
        int parameterCount = hobby.getParameterCount();
        Parameter[] parameters = hobby.getParameters();
        Class<?>[] parameterTypes = hobby.getParameterTypes();
        TypeVariable<Method>[] typeParameters = hobby.getTypeParameters();
        boolean accessible1 = hobby.isAccessible();
        // ***设置访问权限，所有类型的修饰符失效，如private
        hobby.setAccessible(true);
        boolean accessible2 = hobby.isAccessible();
        Object invoke = hobby.invoke(father, "跳钢管舞");
        // 5.获取接口
        Class<?>[] interfaces = fatherClass.getInterfaces();
        AnnotatedType[] annotatedInterfaces = fatherClass.getAnnotatedInterfaces();
        Type[] genericInterfaces = fatherClass.getGenericInterfaces();
        // 6.获取注解
        Son son = new Son();
        Class<? extends Son> sonClass = son.getClass();
        Annotation[] annotationsByType = sonClass.getAnnotationsByType(Value.class);
        Value[] declaredAnnotationsByType = sonClass.getDeclaredAnnotationsByType(Value.class);
        Annotation[] declaredAnnotations = sonClass.getDeclaredAnnotations();
        Annotation annotation = sonClass.getAnnotation(Value.class);
        Annotation[] annotations = sonClass.getAnnotations();

        System.out.println("breakpoint 断点 - 查看变量值");
    }


    /**
     * 获取Class对象三大方法
     */
    @SneakyThrows
    public static void getClassOfThreeFun() {
        // 1.通过全路径类名获取类
        @SuppressWarnings(value = "unchecked")
        Class<Father> fatherClass1 = (Class<Father>) Class.forName("reflectionTest.object.Father");
        System.out.println("1 - Class.forName: " + fatherClass1);
        // 2.通过.class获取
        Class<Father> fatherClass2 = Father.class;
        System.out.println("2 - Class.forName: " + fatherClass2);
        // 3.通过getCLass()获取
        Father father = new Father();
        Class<? extends Father> fatherClass3 = father.getClass();
        System.out.println("3 - Class.forName: " + fatherClass3);
    }
}
