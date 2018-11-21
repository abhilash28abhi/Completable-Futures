package com.java.completable.transformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * If you don’t want to return anything from your callback function and just
 * want to run some piece of code after the completion of the Future, then you
 * can use thenAccept() and thenRun() methods. These methods are consumers and
 * are often used as the last callback in the callback chain
 */
public class CompletableFutureThenAccept {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture.supplyAsync(() -> {
			return "Abhilash";
		}).thenAccept(name -> {
			System.out.println("Hello " + name);
		});
	}
}