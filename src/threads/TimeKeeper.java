package threads;

public class TimeKeeper {

	public static long time(Runnable task) {
		long startTime = System.currentTimeMillis();
		task.run();
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
		return elapsedTime;
	}

}
