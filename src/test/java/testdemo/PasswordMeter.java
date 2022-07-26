package testdemo;

public class PasswordMeter {

	public PasswordStrength meter(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new IllegalArgumentException();
		}

		boolean lengthRule = pw.length() >= 8;
		if (!lengthRule) {
			return PasswordStrength.NOMAL;
		}

		boolean containUp = containsUpperCase(pw);
		if (!containUp) {
			return PasswordStrength.NOMAL;
		}

		return PasswordStrength.STRONG;
	}

	private boolean containsUpperCase(String pw) {
		for (char c : pw.toCharArray()) {
			if ('A' <= c && 'Z' >= c) {
				return true;
			}
		}
		return false;
	}
}
