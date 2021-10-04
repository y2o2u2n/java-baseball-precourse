package baseball;

public enum GameExitCode {
	RESTART("1"),
	EXIT("2");

	private final String code;

	GameExitCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
