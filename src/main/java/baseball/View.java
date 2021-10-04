package baseball;

public class View {
	public static void out(String message) {
		System.out.printf("%s%n", message);
	}

	public static void error(String message) {
		System.err.printf("[ERROR] %s%n", message);
	}
}
