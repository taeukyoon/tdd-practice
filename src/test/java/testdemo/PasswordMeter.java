package testdemo;

public class PasswordMeter {

	public void meter(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}
