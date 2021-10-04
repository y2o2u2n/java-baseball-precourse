package baseball;

public class Player {

	public Balls guess(String input) {
		return new Balls(input);
	}

	GameExitCode exit(String input) {
		if ("1".equals(input)) {
			return GameExitCode.RESTART;
		}
		if ("2".equals(input)) {
			return GameExitCode.EXIT;
		}

		throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
	}
}
