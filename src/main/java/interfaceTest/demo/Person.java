package interfaceTest.demo;


public interface Person {

	void action();

	default void print(){
		System.out.println("我是一个人");
	}
}
