package baseball;

public class Player {
	private static final String MESSAGE_ON_BAD_GAME_EXIT_CODE_INPUT = "1 또는 2를 입력해주세요.";

	public Balls guess(String input) {
		try {
			return new Balls(input);
		} catch (IllegalArgumentException e) {
			throw new BadInputException(e.getMessage());
		}
	}

	GameExitCode exit(String input) {
		if (GameExitCode.RESTART.getCode().equals(input)) {
			return GameExitCode.RESTART;
		}
		if (GameExitCode.EXIT.getCode().equals(input)) {
			return GameExitCode.EXIT;
		}

		throw new BadInputException(MESSAGE_ON_BAD_GAME_EXIT_CODE_INPUT);
	}
}
