package baseball;

public class BadInputException extends RuntimeException {
	private static final String FORMAT = "입력값을 다시 확인해주세요. %s";

	public BadInputException(String message) {
		super(String.format(FORMAT, message));
	}
}
