package baseball;

public class NumberStringUtil {
	public static int pick(String str, int index) {
		try {
			Integer.parseInt(str);
			return str.charAt(index) - '0';
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("문자는 포함될 수 없습니다.");
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("문자열의 범위를 벗어날 수 없습니다.");
		}
	}
}
