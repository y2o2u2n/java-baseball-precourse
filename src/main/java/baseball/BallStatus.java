package baseball;

public enum BallStatus {
	STRIKE(0),
	BALL(1),
	FOUR_BALL(2);

	private final int priority;

	BallStatus(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

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
