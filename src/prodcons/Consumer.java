package prodcons;

import java.util.Queue;

public class Consumer extends Thread {
	private Queue<Integer> queue;
	
	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		while(true) {
			Integer elem = null;
			synchronized (queue) {
				if (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						return;
					}
				}
				elem = queue.remove();
			}
			processElem(elem);
		}
	}

	private void processElem(int elem) {
		System.out.println(elem + " ");
	}
}
