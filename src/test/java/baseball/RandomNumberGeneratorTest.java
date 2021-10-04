package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

	@DisplayName("랜덤 숫자를 n개 만큼 중복되지 않게 생성할 수 있다.")
	@RepeatedTest(value = 100)
	public void generate() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		List<Integer> numbers = randomNumberGenerator.generate();

		assertAll(
			() -> assertThat(numbers).hasSize(3),
			() -> assertThat(numbers).doesNotHaveDuplicates(),
			() -> {
				for (int number : numbers) {
					assertThat(number).isBetween(1, 9);
				}
			}
		);
	}
}
