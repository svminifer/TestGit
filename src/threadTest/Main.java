package threadTest;


public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int finalI = i;
			new Thread(() -> {
				try {
					Thread.sleep(1000);
					System.out.println(finalI);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

		System.out.println("+++++++++++++++++++++++++++++++++++++");
	}

}
