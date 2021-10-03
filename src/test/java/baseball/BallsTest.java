package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsTest {

	@DisplayName("야구공들을 생성할 수 있다.")
	@ParameterizedTest
	@CsvSource({"1, 2, 3", "2, 5, 7"})
	void constructor(int a1, int a2, int a3) {
		// given & when
		Balls balls = new Balls(a1, a2, a3);
		// then
		assertThat(balls.getValues()).isEqualTo(Arrays.asList(new Ball(a1), new Ball(a2), new Ball(a3)));
	}

	@DisplayName("3개의 야구공이 서로 다른 숫자를 가지지 않으면 야구공들을 생성할 수 없다.")
	@ParameterizedTest
	@CsvSource({"1, 1, 2", "7, 3, 3"})
	void constructor_fail(int a1, int a2, int a3) {
		// given & when & then
		assertThatThrownBy(() -> new Balls(a1, a2, a3)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("동등성")
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 1, 2, 3", "7, 9, 3, 7, 9, 3"})
	void equals(int a1, int a2, int a3, int b1, int b2, int b3) {
		// given & when & then
		assertThat(new Balls(a1, a2, a3)).isEqualTo(new Balls(b1, b2, b3));
	}
}
