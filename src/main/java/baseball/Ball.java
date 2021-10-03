package baseball;

import java.util.Objects;

public class Ball {
	private final Position position;
	private final Number number;

	public Ball(int position, int number) {
		this.position = new Position(position);
		this.number = new Number(number);
	}

	public Position getPosition() {
		return position;
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
		return Objects.equals(position, ball.position) && Objects.equals(number, ball.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, number);
	}
}
