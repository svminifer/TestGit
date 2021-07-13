package reflectionTest;


import org.reflections.Reflections;
import reflectionTest.object.Father;
import reflectionTest.object.Value;
import reflectionTest.object.Work;

import java.util.Set;


/**
 * 反射工具类
 */
public class ReflectionAPI {

	public static void main(String[] args) {
		// 要扫描的包名
		Reflections r = new Reflections("reflectionTest.object");
		// 获取继承父类的所有类
		Set<Class<? extends Father>> fatherClasses = r.getSubTypesOf(Father.class);
		// 获取实现接口的所有类
		Set<Class<? extends Work>> workClasses = r.getSubTypesOf(Work.class);
		// 获取标记注解的所有类
		Set<Class<?>> annotationClasses = r.getTypesAnnotatedWith(Value.class);

		System.out.println("break point");
	}

}
