package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
	@Override
	public List<Integer> generate() {
		List<Integer> numbers = new ArrayList<>();

		while (numbers.size() != 3) {
			int number = Randoms.pickNumberInRange(1, 9);
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
