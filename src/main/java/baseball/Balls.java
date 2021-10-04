package baseball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Balls {
	private final List<Ball> values;

	public Balls(List<Integer> numbers) {
		validate(numbers);

		List<Ball> values = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			values.add(new Ball(i, numbers.get(i)));
		}

		this.values = values;
	}

	public Balls(int... nums) {
		List<Integer> numbers = mapToList(nums);
		validate(numbers);

		List<Ball> values = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			values.add(new Ball(i, numbers.get(i)));
		}

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

	private List<Integer> mapToList(int... numbers) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int number : numbers) {
			list.add(number);
		}

		return list;
	}

	private void validate(List<Integer> numbers) {
		if (numbers == null || numbers.size() != 3) {
			throw new IllegalArgumentException("3개의 야구공이어야 합니다.");
		}

		int first = numbers.get(0);
		int second = numbers.get(1);
		int third = numbers.get(2);
		if (first == second || second == third || third == first) {
			throw new IllegalArgumentException("3개의 야구공은 서로 다른 숫자를 가져야 합니다.");
		}
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
