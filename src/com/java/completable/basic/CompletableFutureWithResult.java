package com.java.completable.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The Class CompletableFutureNoResult will run asynchronously and return the result of the future.
 * 
 * */
public class CompletableFutureWithResult {

	public static void main (String[] args) throws InterruptedException, ExecutionException {
		
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			return "Result of the asynchronous computation returing a result";
		});

		// Block and wait for the future to complete
		String result = future.get();
		System.out.println(result);
	}
}
