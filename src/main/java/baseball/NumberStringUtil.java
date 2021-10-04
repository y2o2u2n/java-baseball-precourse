package baseball;

public class NumberStringUtil {
	private static final String MESSAGE_ON_NOT_NUMBER = "문자는 포함될 수 없습니다.";
	private static final String MESSAGE_ON_INDEX_OUT = "문자열의 범위를 벗어날 수 없습니다.";

	public static int pick(String str, int index) {
		try {
			Integer.parseInt(str);
			return str.charAt(index) - '0';
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_ON_NOT_NUMBER);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(MESSAGE_ON_INDEX_OUT);
		}
	}
}
