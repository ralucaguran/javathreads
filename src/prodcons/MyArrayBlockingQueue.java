package prodcons;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyArrayBlockingQueue<E> extends ArrayDeque<E> implements BlockingQueue<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1175507402936968241L;
	
	public MyArrayBlockingQueue(int numElements) {
		super(numElements);
	}

	@Override
	public synchronized void put(E e) throws InterruptedException {
		add(e);
		notify();
	}

	@Override
	public synchronized E take() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		return pop();
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		throw new UnsupportedOperationException();
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int remainingCapacity() {
		throw new UnsupportedOperationException();
	}

}
