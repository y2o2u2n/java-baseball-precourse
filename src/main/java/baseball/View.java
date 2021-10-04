package baseball;

public class View {
	public static void out(String message) {
		System.out.printf("%s%n", message);
	}

	public static void out(RuntimeException e) {
		System.out.printf("[ERROR] %s%n", e.getMessage());
	}
}
