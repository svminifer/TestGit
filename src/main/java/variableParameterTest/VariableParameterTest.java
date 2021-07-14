package variableParameterTest;


/**
 * <pre>
 * 1.可变参数需要放到最后一个入参
 * 2.可变参数String... params 与 String[] 无大差别，String... params比较灵活
 * </pre>
 */
public class VariableParameterTest {

	public static void main(String[] args) {
		System.out.println("test1:");
		test("a", "b", "c");
		System.out.println("test2:");
		test(new String[] { "a", "b", "c" });

		String[] strings = new String[] { "1", "2", "3", "4" };

		test(strings);
	}

	/**
	 * 测试方法1
	 *
	 * @param params 参数
	 */
	public static void test(String... params) {
		//遍历参数内容
		for (String temp : params) {
			System.out.println(temp);
		}
		System.out.println();
	}

	/**
	 * 测试方法2
	 *
	 * @param intParam 参数1
	 * @param params   String... params只能放在最后位，因此只能有一个（String[]无此限制）
	 */
	public static void test(int intParam, String... params) {
		System.out.println("int:" + intParam);
		//遍历参数内容
		for (String temp : params) {
			System.out.println(temp);
		}
		System.out.println();
	}

}
