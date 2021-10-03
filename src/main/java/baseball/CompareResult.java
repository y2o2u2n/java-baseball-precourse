package baseball;

public class CompareResult {
	private int strikeCount = 0;
	private int ballCount = 0;

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void report(BallStatus status) {
		if (status.isStrike()) {
			strikeCount++;
		}

		if (status.isBall()) {
			ballCount++;
		}
	}
}
