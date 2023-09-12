import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		new MainClass().run();
	}

	private void run() {
		Scanner _key = new Scanner(System.in);
		double a;
		double b;
		String t1;
		a = _key.nextDouble();
		b = _key.nextDouble();
		a = 1 + 2 * 3 / b;
		System.out.println("(1, 2)");
		if (a >= b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}

		System.out.println("(1, 2)");
		System.out.println(1);
		System.out.println("a");
		System.out.println(true);
		System.out.println(false);
		System.out.println(2332);
	}
}