package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Balls {
	private static final String MESSAGE_ON_INVALID_LENGTH = "3개의 야구공이어야 합니다.";
	private static final String MESSAGE_ON_NOT_NUMBER = "숫자를 입력해야 합니다.";
	private static final String MESSAGE_ON_DUPLICATE = "3개의 야구공은 서로 다른 숫자를 가져야 합니다.";

	private final List<Ball> values;

	public Balls(List<Integer> numbers) {
		this.values = makeBalls(numbers);
	}

	public Balls(int... ints) {
		List<Integer> numbers = mapToList(ints);
		this.values = makeBalls(numbers);
	}

	public Balls(String str) {
		List<Integer> numbers = mapToList(str);
		this.values = makeBalls(numbers);
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

	private List<Ball> makeBalls(List<Integer> numbers) {
		validate(numbers);

		List<Ball> values = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			values.add(new Ball(i, numbers.get(i)));
		}

		return values;
	}

	private List<Integer> mapToList(int... ints) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i : ints) {
			list.add(i);
		}

		return list;
	}

	private List<Integer> mapToList(String str) {
		validate(str);

		return Arrays.asList(
			NumberStringUtil.pick(str, 0),
			NumberStringUtil.pick(str, 1),
			NumberStringUtil.pick(str, 2));
	}

	private void validate(String str) {
		if (str == null || str.length() != 3) {
			throw new IllegalArgumentException(MESSAGE_ON_INVALID_LENGTH);
		}

		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_ON_NOT_NUMBER);
		}
	}

	private void validate(List<Integer> numbers) {
		if (numbers == null || numbers.size() != 3) {
			throw new IllegalArgumentException(MESSAGE_ON_INVALID_LENGTH);
		}

		int first = numbers.get(0);
		int second = numbers.get(1);
		int third = numbers.get(2);
		if (first == second || second == third || third == first) {
			throw new IllegalArgumentException(MESSAGE_ON_DUPLICATE);
		}
	}

	public List<Ball> getValues() {
		return values;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Balls balls = (Balls)object;
		return Objects.equals(values, balls.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
