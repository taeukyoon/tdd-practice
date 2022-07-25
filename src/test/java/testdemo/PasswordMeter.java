package testdemo;

public class PasswordMeter {

	public PasswordStrength meter(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new IllegalArgumentException();
		}

		boolean length = pw.length() >= 8;
		if (!length) {
			return PasswordStrength.NOMAL;
		}

		return PasswordStrength.STRONG;
	}
}
