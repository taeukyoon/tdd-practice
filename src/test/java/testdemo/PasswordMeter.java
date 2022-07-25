package testdemo;

public class PasswordMeter {

	public void meter(String pw) {
		if (pw == null) {
			throw new IllegalArgumentException();
		}
	}
}
