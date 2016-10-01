package prodcons;

import java.util.concurrent.BlockingQueue;

public class SimpleConsumer implements Runnable {
	private BlockingQueue<Integer> queue;
	
	public SimpleConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			Integer elem = null;
			try {
				elem = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			processElem(elem);
		}
	}

	private void processElem(int elem) {
		System.out.println(elem + " ");
	}
}
