package blackBoxInteger;

public class BlackBoxInt {

	private static final int DEFAULT_VALUE = 0;

	private int innerValue;

	private BlackBoxInt(int innerValue) {
		this.innerValue = innerValue;
	}

	private BlackBoxInt() {
		this.innerValue = DEFAULT_VALUE;
	}

	private void add(int addend) {
		this.innerValue += addend;
	}

	private void subtract(int subtrahend) {
		this.innerValue -= subtrahend;
	}

	private void multiply(int multiplier) {
		this.innerValue *= multiplier;
	}

	private void divide(int divider) {
		this.innerValue /= divider;
	}

	private void leftShift(int shifter) {
		this.innerValue <<= shifter;
	}

	private void rightShift(int shifter) {
		this.innerValue >>= shifter;
	}
}
