package com.jeasyframeworks.toolkit.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorsKit {

	static ExecutorService cachedThreadPool;
	static ExecutorService fixedThreadPool;
	static ExecutorService scheduledThreadPool;
	static ExecutorService singleThreadExecutor;

	public static ExecutorService cachedThreadPool() {
		if (cachedThreadPool == null)
			cachedThreadPool = newCachedThreadPool();
		return cachedThreadPool;
	}

	public static ExecutorService newCachedThreadPool() {
		return Executors.newCachedThreadPool();
	}

	public static ExecutorService fixedThreadPool() {
		if (fixedThreadPool == null)
			fixedThreadPool = newFixedThreadPool(10);
		return fixedThreadPool;
	}

	public static ExecutorService newFixedThreadPool(int num) {
		return Executors.newFixedThreadPool(num);
	}

	public static ExecutorService scheduledThreadPool() {
		if (scheduledThreadPool == null)
			scheduledThreadPool = newScheduledThreadPool(10);
		return scheduledThreadPool;
	}

	public static ExecutorService newScheduledThreadPool(int num) {
		return Executors.newScheduledThreadPool(num);
	}

	public static ExecutorService singleThreadExecutor() {
		if (singleThreadExecutor == null)
			singleThreadExecutor = newSingleThreadExecutor();
		return singleThreadExecutor;
	}

	public static ExecutorService newSingleThreadExecutor() {
		return Executors.newSingleThreadExecutor();
	}
}
