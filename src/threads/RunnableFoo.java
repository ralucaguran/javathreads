package threads;

public class RunnableFoo implements Runnable {
	private Counter counter;
	private int threshold;
	
	public RunnableFoo(Counter counter, int threshold) {
		this.counter = counter;
		this.threshold = threshold;
	}

	@Override
	public void run() {
		for(int i=0; i<threshold; ++i) {
			this.counter.increment();
		}
	}

}
