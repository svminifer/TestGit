package interfaceTest.demo;


public class Main {

	public static void main(String[] args) {
		School school = new School();
		school.setPerson(new Teacher());

		school.getPerson().action();
	}

}
