package prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
		Executor exec = Executors.newCachedThreadPool();
		exec.execute(new SimpleProducer(queue, 5));
		exec.execute(new SimpleProducer(queue, 7));
		exec.execute(new SimpleConsumer(queue));
	}

}
