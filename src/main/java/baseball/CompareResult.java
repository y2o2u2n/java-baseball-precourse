package baseball;

import java.util.ArrayList;
import java.util.List;

public class CompareResult {
	private static final String NOTHING = "낫싱";
	private static final String STRIKE_FORMAT = "%s스트라이크";
	private static final String BALL_FORMAT = "%s볼";
	private static final String DELIMITER = " ";

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

	public boolean isAnswer() {
		return strikeCount == 3;
	}

	public String toMessage() {
		if (strikeCount == 0 && ballCount == 0) {
			return NOTHING;
		}

		List<String> snippets = new ArrayList<>();
		addSnippet(snippets, STRIKE_FORMAT, strikeCount);
		addSnippet(snippets, BALL_FORMAT, ballCount);
		return String.join(DELIMITER, snippets);
	}

	private void addSnippet(List<String> snippets, String format, int count) {
		if (count > 0) {
			snippets.add(String.format(format, count));
		}
	}
}
