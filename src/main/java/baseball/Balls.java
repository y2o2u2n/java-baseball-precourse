package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Balls {
	private final List<Ball> values;

	public Balls(int first, int second, int third) {
		if (first == second || second == third || third == first) {
			throw new IllegalArgumentException("3개의 야구공은 서로 다른 숫자를 가져야 합니다.");
		}

		this.values = Arrays.asList(new Ball(first), new Ball(second), new Ball(third));
	}

	public List<Ball> getValues() {
		return values;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Balls balls = (Balls)o;
		return Objects.equals(values, balls.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
