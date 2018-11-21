package com.java.completable.transformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The thenApply() acts as a callback method for the future result. 
 * The method is executed when the future is completed, it then calls the thenApply method.
 * 
 */
public class CompletableFutureThenApplyChain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			return "Abhilash";
		}).thenApply((name) -> {
			return "Hello " + name;
		}).thenApply(greeting -> {
			return greeting + ", Welcome to the Java Completable Futures";
		});

		// Block and get the result of the future.
		System.out.println(future.get());
	}
}
