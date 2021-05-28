package interfaceTest.demo;


public class Student implements Person {

	@Override
	public void action() {
		System.out.println("学习");
	}

	@Override
	public void print() {
		System.out.println("我是一个学生");
	}

}
