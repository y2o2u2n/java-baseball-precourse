package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
		assertThat(balls.getValues()).isEqualTo(Arrays.asList(new Ball(0, a1), new Ball(1, a2), new Ball(2, a3)));
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

	@DisplayName("스트라이크")
	@Test
	void strike() {
		// given
		Balls aBalls = new Balls(1, 2, 3);
		Ball bBall = new Ball(0, 1);

		// when
		BallStatus status = Balls.compare(aBalls, bBall);

		// then
		assertThat(status.isStrike()).isTrue();
	}

	@DisplayName("볼")
	@Test
	void ball() {
		// given
		Balls aBalls = new Balls(1, 2, 3);
		Ball bBall = new Ball(2, 1);

		// when
		BallStatus status = Balls.compare(aBalls, bBall);

		// then
		assertThat(status.isBall()).isTrue();
	}

	@DisplayName("포볼")
	@Test
	void four_ball() {
		// given
		Balls aBalls = new Balls(1, 2, 3);
		Ball bBall = new Ball(2, 7);

		// when
		BallStatus status = Balls.compare(aBalls, bBall);

		// then
		assertThat(status.isFourBall()).isTrue();
	}

	@DisplayName("비교 결과를 확인할 수 있다.")
	@ParameterizedTest
	@CsvSource({
		"7,1,3,1,2,3,1,1",
		"7,1,3,1,4,5,0,1",
		"7,1,3,6,7,1,0,2",
		"7,1,3,2,1,6,1,0",
		"7,1,3,7,1,3,3,0"
	})
	void compare(
		int a1, int a2, int a3,
		int b1, int b2, int b3,
		int strikeCount, int ballCount
	) {
		// given
		Balls aBalls = new Balls(a1, a2, a3);
		Balls bBalls = new Balls(b1, b2, b3);

		// when
		CompareResult result = Balls.compare(aBalls, bBalls);

		// then
		assertAll(
			() -> assertThat(result).isNotNull(),
			() -> assertThat(result.getStrikeCount()).isEqualTo(strikeCount),
			() -> assertThat(result.getBallCount()).isEqualTo(ballCount)
		);
	}
}
