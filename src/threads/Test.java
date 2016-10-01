package threads;

public class Test implements Runnable {

	public static void main(String[] args) {
		//UnsyncCounter counter = new UnsyncCounter();
		//SyncCounter counter = new SyncCounter();
		exec(new AtomicCounter());
		exec(new SyncCounter());
	}

	private static void exec(Counter counter) {
		int threshold = 100000;
		long elapsedTime = TimeKeeper.time(new Test(counter, threshold));
	    assert(counter.value() == threshold);
		System.out.println(counter.getClass().getSimpleName() + " elapsed time = " + elapsedTime + " milliseconds");
	}
	
	private Counter counter;
	private int threshold;
	
	public Test(Counter counter, int threshold) {
		this.counter = counter;
		this.threshold = threshold;
	}

	public void run() {
		Thread fooT1 = new Thread(new RunnableFoo(counter, threshold));
		fooT1.start();
		Thread fooT2 = new Thread(new RunnableFoo(counter, threshold));
		fooT2.start();
		try {
			fooT1.join();
			fooT2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return;
	}
	
}
