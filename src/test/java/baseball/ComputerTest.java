package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {

	@DisplayName("컴퓨터를 생성할 수 있다.")
	@ParameterizedTest
	@CsvSource({"1, 6, 2", "7, 2, 3"})
	void constructor(int n1, int n2, int n3) {
		// given & when
		Computer computer = new Computer(() -> Arrays.asList(n1, n2, n3));

		// then
		assertThat(computer.getBalls()).isEqualTo(new Balls(n1, n2, n3));
	}
}
