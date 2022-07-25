package testdemo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

	private PasswordMeter passwordMeter = new PasswordMeter();

	@DisplayName("null 입력하면 예외 발생")
	@Test
	void nullInput() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> passwordMeter.meter(null));
	}

	@DisplayName("공백을 입력하면 예외 발생")
	@Test
	void blankInput() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> passwordMeter.meter(""));
	}

	@DisplayName("조건을 모두 충족하면 강함")
	@Test
	void meetAllRules() {
		PasswordStrength result = passwordMeter.meter("1Q23432wer");
		assertThat(result).isEqualTo(PasswordStrength.STRONG);
	}

	@DisplayName("길이가 8미만, 나머지 조건 만족")
	@Test
	void digitAndUpperCase() {
		PasswordStrength result = passwordMeter.meter("1Q234");
		assertThat(result).isEqualTo(PasswordStrength.NOMAL);
	}
}