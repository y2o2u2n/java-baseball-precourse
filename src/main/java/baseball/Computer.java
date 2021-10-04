package baseball;

public class Computer {
	private final Balls balls;

	public Computer(NumberGenerator numberGenerator) {
		this.balls = new Balls(numberGenerator.generate());
	}

	public Balls getBalls() {
		return balls;
	}
}
