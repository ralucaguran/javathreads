package prodcons;

import java.util.Queue;

public class Producer extends Thread {
	private Queue<Integer> queue;
	
	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		while(true) {
			synchronized (queue) {
				queue.add(new Integer(5));
				queue.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
