package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class RandomNumberGenerator {
	public List<Integer> generate(int startInclusive, int endInclusive, int size) {
		List<Integer> numbers = new ArrayList<>();

		while (numbers.size() != size) {
			int number = Randoms.pickNumberInRange(startInclusive, endInclusive);
			addOnDoesNotContain(numbers, number);
		}

		return numbers;
	}

	private void addOnDoesNotContain(List<Integer> numbers, int number) {
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
	}
}
