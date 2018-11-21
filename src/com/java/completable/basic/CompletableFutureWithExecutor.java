package com.java.completable.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture executes these tasks in a thread obtained from the global ForkJoinPool.commonPool().
 * All the methods in the CompletableFuture API has two variants - One which accepts an Executor as an argument and one which doesn’t.
 *
 */
public class CompletableFutureWithExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//creating our own executor
		Executor executor = Executors.newFixedThreadPool(4);
		
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			return "Result of the asynchronous computation returing a result";
		}, executor);

		// Block and wait for the future to complete
		String result = future.get();
		System.out.println(result);
	}
}
