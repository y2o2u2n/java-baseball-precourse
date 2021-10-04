package baseball;

import java.util.Objects;

public class Number {
	private static final int LOWER_BOUND = 1;
	private static final int UPPER_BOUND = 9;
	private static final String MESSAGE_ON_INVALID = "숫자는 1에서 9사이어야 합니다.";

	private final int value;

	public Number(int value) {
		if (!(value >= LOWER_BOUND && value <= UPPER_BOUND)) {
			throw new IllegalArgumentException(MESSAGE_ON_INVALID);
		}

		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Number number = (Number)object;
		return value == number.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
