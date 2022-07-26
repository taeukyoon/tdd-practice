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
		assertPasswordStrength("1Q23432wer", PasswordStrength.STRONG);
	}

	@DisplayName("길이가 8미만, 나머지 조건 만족")
	@Test
	void digitAndUpperCase() {
		assertPasswordStrength("1Q234", PasswordStrength.NOMAL);
		assertPasswordStrength("Q2334", PasswordStrength.NOMAL);
		assertPasswordStrength("Q23234", PasswordStrength.NOMAL);
	}

	@DisplayName("대문자 없음, 나머지 조건 만족")
	@Test
	void digitAndLength() {
		assertPasswordStrength("1q234wrewr", PasswordStrength.NOMAL);
		assertPasswordStrength("1q234ww335", PasswordStrength.NOMAL);
		assertPasswordStrength("1q234w4332235", PasswordStrength.NOMAL);
	}

	@DisplayName("숫자 없음, 나머지 조건 만족")
	@Test
	void lengthAndUpperCase() {
		assertPasswordStrength("qweqQqwrkak", PasswordStrength.NOMAL);
		assertPasswordStrength("BaSLsdawdw", PasswordStrength.NOMAL);
		assertPasswordStrength("BBcqqqqqqqq", PasswordStrength.NOMAL);
	}

	@DisplayName("길이만 충족")
	@Test
	void length() {
		assertPasswordStrength("qweqeqewqrwq", PasswordStrength.WEAK);
		assertPasswordStrength("retretetret", PasswordStrength.WEAK);
		assertPasswordStrength("fksfklekwlqk", PasswordStrength.WEAK);
	}

	private void assertPasswordStrength(String pw, PasswordStrength expected) {
		PasswordStrength result = passwordMeter.meter(pw);
		assertThat(result).isEqualTo(expected);
	}
}