package baseball;

import java.util.Objects;

public class Ball {
	private final Number number;

	public Ball(int value) {
		this.number = new Number(value);
	}

	public Number getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return Objects.equals(number, ball.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
