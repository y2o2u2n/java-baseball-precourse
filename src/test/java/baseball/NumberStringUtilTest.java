package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberStringUtilTest {

	@DisplayName("숫자로 이루어진 문자열에서 n번째 숫자를 뽑아낼 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {
		"123, 0, 1",
		"123, 1, 2",
		"123, 2, 3"
	})
	void pick(String str, int index, int expected) {
		// given & when &then
		Assertions.assertThat(NumberStringUtil.pick(str, index)).isEqualTo(expected);
	}

	@DisplayName("숫자가 아닌 문자가 포함된 문자열이면 뽑아낼 수 없다.")
	@ParameterizedTest
	@CsvSource(value = {"a23, 0"})
	void pick_fail_not_number(String str, int index) {
		// given & when & then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> NumberStringUtil.pick(str, index));
	}

	@DisplayName("인덱스를 벗어난 n번째 숫자를 뽑아낼 수 없다.")
	@ParameterizedTest
	@CsvSource(value = {"a23, 5"})
	void pick_fail_index_out(String str, int index) {
		// given & when & then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> NumberStringUtil.pick(str, index));
	}
}
