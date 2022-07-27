package testdemo;

public class PasswordMeter {

	public PasswordStrength meter(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new IllegalArgumentException();
		}

		int metCount = calculateMetCount(pw);
		if (metCount == 1 || metCount == 0) return PasswordStrength.WEAK;
		if (metCount == 2) return PasswordStrength.NOMAL;

		return PasswordStrength.STRONG;
	}

	private int calculateMetCount(String pw) {
		int metCount = 0;
		if (pw.length() >= 8) metCount++;
		if (containsUpperCase(pw)) metCount++;
		if (containNumber(pw)) metCount++;
		return metCount;
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
