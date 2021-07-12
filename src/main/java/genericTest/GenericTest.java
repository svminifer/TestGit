package genericTest;


import genericTest.object.Animal;
import genericTest.object.Cat;
import genericTest.object.Demo;
import genericTest.object.Dog;

import java.util.ArrayList;


/**
 * E、T 无区别，仅用于表示不同的含义
 * E 表示元素，写法常用于集合 如：ArrayList<E>
 * T 表示类型，写法常用于类型 如：Class<T>
 * K V 表示键、值 常用于Map<k,v>
 * <p>
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ? -  表示不确定的java类型
 */
public class GenericTest {

	public static void main(String[] args) {
		// 测试一
		Demo<Dog> dogDemo = new Demo<>(new Dog());
		take(dogDemo);
		otherTake(dogDemo);
		Demo<Cat> catDemo = new Demo<>(new Cat());
		take(catDemo);
		otherTake(catDemo);
		// 测试二
		ArrayList<String> str = new ArrayList<>();
		str.add("指定是String类型的类");
		test1(str);

		// ArrayList<?> arrayList = new ArrayList();与下者无差别
		ArrayList arrayList = new ArrayList();
		arrayList.add(1);
		arrayList.add(new Dog());
		arrayList.add("各种类型的类");
	}

	// 也可以理解为继承Animal下所有子类，但不确定是那个子类，就使用泛型通配符 ?
	static void take(Demo<?> animal) {
		animal.print();
	}

	static <T extends Animal> void otherTake(Demo<T> a) {
		a.print();
	}

	static <E> E test1(ArrayList<E> arrayList) {
		E t = arrayList.get(0);
		return t;
	}

	static void test2(ArrayList<?> arrayList) {
		Object o = arrayList.get(0);
	}

	static void test3(ArrayList arrayList) {
		Object o = arrayList.get(0);
	}

}
