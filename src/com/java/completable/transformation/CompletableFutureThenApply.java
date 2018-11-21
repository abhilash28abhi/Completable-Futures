package com.java.completable.transformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The thenApply() acts as a callback method for the future result. The method is executed when the 
 * future is completed, it then calls the thenApply method.
 * Simply put thenApply means run this function on a result when it arrives
 */
public class CompletableFutureThenApply {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			return "Abhilash";
		});

		// Attach a callback to the Future using thenApply() 
	    // Executed in the same thread where the supplyAsync() task is executed or in the main thread 
		// If the supplyAsync() task completes immediately
		CompletableFuture<String> nameFuture = future.thenApply(name -> {
			return "Hello " + name;
		});

		// Block and get the result of the future.
		System.out.println(nameFuture.get());
	}
}
