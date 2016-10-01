package prodcons;

import java.util.concurrent.BlockingQueue;

public class SimpleProducer implements Runnable {
	private BlockingQueue<Integer> queue;
	int value;
	
	public SimpleProducer(BlockingQueue<Integer> queue, int value) {
		this.queue = queue;
		this.value = value;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				queue.put(value);
				Thread.sleep(100 * value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
