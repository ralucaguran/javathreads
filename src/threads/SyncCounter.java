package threads;

public class SyncCounter implements Counter {
	private int count = 0;
	
	synchronized public void increment() {
		++count;
	}
	
	synchronized public void decrement() {
		--count;
	}
	
	synchronized public int value() {
		return count;
	}
}
