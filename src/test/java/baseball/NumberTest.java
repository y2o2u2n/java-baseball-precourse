package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

	@DisplayName("1에서 9사이의 숫자 중 하나일 경우 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
	void constructor(int value) {
		// given & when
		Number number = new Number(value);
		// then
		assertThat(number.getValue()).isEqualTo(value);
	}

	@DisplayName("1에서 9사이의 숫자가 아닐 경우 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "10"})
	void constructor_fail(int value) {
		// given & when & then
		assertThatThrownBy(() -> new Number(value)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("동등성")
	@ParameterizedTest
	@ValueSource(strings = {"2", "3", "5"})
	void equals(int value) {
		// given & when & then
		assertThat(new Number(value)).isEqualTo(new Number(value));
	}
}
