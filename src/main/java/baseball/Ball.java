package baseball;

import java.util.Objects;

public class Ball {
	private final Position position;
	private final Number number;

	public Ball(int position, int number) {
		this.position = new Position(position);
		this.number = new Number(number);
	}

	public static BallStatus compare(Ball aBall, Ball bBall) {
		if (aBall.equals(bBall)) {
			return BallStatus.STRIKE;
		}

		if (aBall.number.equals(bBall.number)) {
			return BallStatus.BALL;
		}

		return BallStatus.FOUR_BALL;
	}

	public Position getPosition() {
		return position;
	}

	public Number getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Ball ball = (Ball)object;
		return Objects.equals(position, ball.position) && Objects.equals(number, ball.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, number);
	}
}
