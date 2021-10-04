package baseball;

public class BadInputException extends RuntimeException {
	public BadInputException(String message) {
		super(String.format("입력값을 다시 확인해주세요. %s", message));
	}
}
