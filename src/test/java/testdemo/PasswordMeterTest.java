package testdemo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

	@DisplayName("null 입력하면 예외 발생")
	@Test
	void nullInput() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new PasswordMeter().meter(null));
	}

	@DisplayName("공백을 입력하면 예외 발생")
	@Test
	void blankInput() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new PasswordMeter().meter(""));
	}
}