package testdemo;

public class PasswordMeter {

	public PasswordStrength meter(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new IllegalArgumentException();
		}

		boolean lengthRule = pw.length() >= 8;
		boolean containUp = containsUpperCase(pw);
		boolean containNum = containNumber(pw);

		int metCount = 0;
		if (lengthRule) metCount++;
		if (containUp) metCount++;
		if (containNum) metCount++;

		if (metCount == 1) return PasswordStrength.WEAK;

		if (!lengthRule) {
			return PasswordStrength.NOMAL;
		}

		if (!containUp) {
			return PasswordStrength.NOMAL;
		}

		if (!containNum) {
			return PasswordStrength.NOMAL;
		}

		return PasswordStrength.STRONG;
	}

	private boolean containNumber(String pw) {
		for (char c : pw.toCharArray()) {
			if ('0' <= c && c <= '9') {
				return true;
			}
		}
		return false;
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
