package baseball;

import java.util.Objects;

public class Position {
	private static final int LOWER_BOUND = 0;
	private static final int UPPER_BOUND = 2;
	private static final String MESSAGE_ON_INVALID = "위치는 0에서 2사이어야 합니다.";

	private final int value;

	public Position(int value) {
		if (!(value >= LOWER_BOUND && value <= UPPER_BOUND)) {
			throw new IllegalArgumentException(MESSAGE_ON_INVALID);
		}

		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return value == position.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
