package baseball;

import nextstep.utils.Console;

public class Game {
	private static final String MESSAGE_ON_GUESS = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_ON_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private final NumberGenerator numberGenerator;
	private final Player player;
	private Computer computer;

	public Game(NumberGenerator numberGenerator, Player player) {
		this.numberGenerator = numberGenerator;
		this.player = player;

		init();
	}

	private void init() {
		GameExitCode code;
		do {
			code = start();
		} while (code == GameExitCode.RESTART);
	}

	private GameExitCode start() {
		createComputer();
		play();
		return end();
	}

	private void createComputer() {
		computer = new Computer(numberGenerator);
	}

	private void play() {
		CompareResult compareResult;
		do {
			View.println(MESSAGE_ON_GUESS);
			Balls computerBalls = computer.getBalls();
			Balls playerBalls = player.guess(Console.readLine());
			compareResult = Balls.compare(computerBalls, playerBalls);
			View.println(compareResult.toMessage());
		} while (!compareResult.isAnswer());
	}

	private GameExitCode end() {
		View.println(MESSAGE_ON_GAME_END);
		return player.exit(Console.readLine());
	}
}
