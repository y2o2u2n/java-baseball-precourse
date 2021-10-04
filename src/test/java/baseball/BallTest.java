package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

	@DisplayName("야구공을 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
	void constructor(int number) {
		// given & when
		Ball ball = new Ball(0, number);
		// then
		assertAll(
			() -> assertThat(ball.getPosition()).isEqualTo(new Position(0)),
			() -> assertThat(ball.getNumber()).isEqualTo(new Number(number))
		);
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

	@DisplayName("두 야구공의 숫자와 위치가 같을 경우 스트라이크이다.")
	@ParameterizedTest
	@CsvSource({"0,7,0,7", "1,8,1,8"})
	void strike(int p1, int n1, int p2, int n2) {
		// given
		Ball a = new Ball(p1, n1);
		Ball b = new Ball(p2, n2);

		// when
		BallStatus status = Ball.compare(a, b);

		// then
		assertThat(status.isStrike()).isTrue();
	}

	@DisplayName("두 야구공의 숫자만 같을 경우 볼이다.")
	@ParameterizedTest
	@CsvSource({"0,7,1,7", "1,8,2,8"})
	void ball(int p1, int n1, int p2, int n2) {
		// given
		Ball a = new Ball(p1, n1);
		Ball b = new Ball(p2, n2);

		// when
		BallStatus status = Ball.compare(a, b);

		// then
		assertThat(status.isBall()).isTrue();
	}

	@DisplayName("두 야구공의 숫자가 같지 않을 경우 포볼이다.")
	@ParameterizedTest
	@CsvSource({"0,7,0,1", "0,7,1,1"})
	void four_ball(int p1, int n1, int p2, int n2) {
		// given
		Ball a = new Ball(p1, n1);
		Ball b = new Ball(p2, n2);

		// when
		BallStatus status = Ball.compare(a, b);

		// then
		assertThat(status.isFourBall()).isTrue();
	}
}
