package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

	@DisplayName("문자열로부터 야구공들을 만들어낼 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"123", "723"})
	void guess(String str) {
		// given
		Player player = new Player();

		// when
		Balls guess = player.guess(str);

		// then
		assertThat(guess).isEqualTo(
			new Balls(
				NumberStringUtil.pick(str, 0),
				NumberStringUtil.pick(str, 1),
				NumberStringUtil.pick(str, 2)));
	}

	@DisplayName("문자열로부터 게임 종료 코드를 반환한다.")
	@Test
	void exit() {
		// given
		Player player = new Player();

		// when & then
		assertThat(player.exit("1")).isEqualTo(GameExitCode.RESTART);
		assertThat(player.exit("2")).isEqualTo(GameExitCode.EXIT);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> player.exit("abc"));
	}
}
