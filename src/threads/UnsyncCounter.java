package threads;

public class UnsyncCounter implements Counter {
	private int count = 0;
	
	public void increment() {
		++count;
	}
	
	public void decrement() {
		--count;
	}
	
	public int value() {
		return count;
	}
}
