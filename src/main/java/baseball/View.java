package baseball;

public class View {
	public static void info(String message) {
		System.out.printf("[INFO] %s%n", message);
	}

	public static void error(String message) {
		System.err.printf("[ERROR] %s%n", message);
	}
}
