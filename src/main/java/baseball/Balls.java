package baseball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Balls {
	private final List<Ball> values;

	public Balls(int first, int second, int third) {
		if (first == second || second == third || third == first) {
			throw new IllegalArgumentException("3개의 야구공은 서로 다른 숫자를 가져야 합니다.");
		}

		ArrayList<Ball> values = new ArrayList<>();
		values.add(new Ball(0, first));
		values.add(new Ball(1, second));
		values.add(new Ball(2, third));
		this.values = values;
	}

	public static CompareResult compare(Balls aBalls, Balls bBalls) {
		CompareResult result = new CompareResult();

		for (Ball bBall : bBalls.values) {
			BallStatus status = compare(aBalls, bBall);
			result.report(status);
		}

		return result;
	}

	protected static BallStatus compare(Balls aBalls, Ball bBall) {
		PriorityQueue<BallStatus> pq = new PriorityQueue<>(Comparator.comparing(BallStatus::getPriority));

		for (Ball aBall : aBalls.values) {
			pq.offer(Ball.compare(aBall, bBall));
		}

		return pq.poll();
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
