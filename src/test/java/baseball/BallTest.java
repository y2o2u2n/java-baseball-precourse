package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

	@DisplayName("야구공을 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
	void constructor(int number) {
		// given & when
		Ball ball = new Ball(0, number);
		// then
		assertThat(ball.getNumber()).isEqualTo(new Number(number));
	}

	@DisplayName("1에서 9사이의 숫자가 아닐 경우 야구공을 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "10"})
	void constructor_fail(int number) {
		// given & when & then
		assertThatThrownBy(() -> new Ball(0, number)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("동등성")
	@ParameterizedTest
	@ValueSource(strings = {"2", "3", "5"})
	void equals(int number) {
		// given & when & then
		assertThat(new Ball(0, number)).isEqualTo(new Ball(0, number));
	}
}
