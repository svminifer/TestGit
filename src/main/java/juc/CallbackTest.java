package juc;


import org.junit.jupiter.api.Test;

/**
 * 回调测试
 */
public class CallbackTest {

	@Test
	public void testCallback() {
		Student student = new Ricky();
		Teacher teacher = new Teacher(student);

		teacher.askQuestion();

	}
}
