package com.java.completable.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The Class CompletableFutureNoResult will run asynchronously without returning the result of the future.
 */
public class CompletableFutureNoResult {

	public static void main (String[] args) throws InterruptedException, ExecutionException {
		
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			System.out.println("I'll run in a separate thread than the main thread.");
		});

		// Block and wait for the future to complete
		future.get();
	}
}
