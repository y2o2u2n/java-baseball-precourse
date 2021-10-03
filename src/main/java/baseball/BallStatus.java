package baseball;

public enum BallStatus {
	STRIKE,
	BALL,
	FOUR_BALL;

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isFourBall() {
		return this == FOUR_BALL;
	}
}
