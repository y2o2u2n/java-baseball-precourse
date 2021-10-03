package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

	@DisplayName("0에서 2사이의 숫자 중 하나일 경우 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"0", "1", "2"})
	void constructor(int value) {
		// given & when
		Position position = new Position(value);
		// then
		assertThat(position.getValue()).isEqualTo(value);
	}

	@DisplayName("0에서 2사이의 숫자가 아닐 경우 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "3"})
	void constructor_fail(int value) {
		// given & when & then
		assertThatThrownBy(() -> new Position(value)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("동등성")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void equals(int value) {
		// given & when & then
		assertThat(new Position(value)).isEqualTo(new Position(value));
	}
}
