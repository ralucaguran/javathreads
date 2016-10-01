package prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static void main(String[] args) {
//		Queue<Integer> queue = new ArrayDeque<Integer>();
//		Producer prod = new Producer(queue);
//		prod.start();
//		Consumer cons = new Consumer(queue);
//		cons.start();
//		try {
//			prod.join();
//			cons.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BlockingQueue<Integer> queue = new MyArrayBlockingQueue<Integer>(100);
		//BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
		Thread prodTh1 = new Thread(new SimpleProducer(queue, 5));
		prodTh1.start();
		Thread prodTh2 = new Thread(new SimpleProducer(queue, 7));
		prodTh2.start();
		Thread consTh1 = new Thread(new SimpleConsumer(queue));
		consTh1.start();
		Thread consTh2 = new Thread(new SimpleConsumer(queue));
		consTh2.start();
		Thread consTh3 = new Thread(new SimpleConsumer(queue));
		consTh3.start();
		try {
			prodTh2.join();
			consTh1.join();
			consTh2.join();
			consTh3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
