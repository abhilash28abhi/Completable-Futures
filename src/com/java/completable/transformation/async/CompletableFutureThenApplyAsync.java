package com.java.completable.transformation.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureThenApplyAsync {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//If you use thenApplyAsync() callback, then it will be executed in a different thread obtained from ForkJoinPool.commonPool()
		//If you pass an Executor to the thenApplyAsync() callback then the task will be executed in a thread obtained from the Executor’s thread pool
		Executor executor = Executors.newFixedThreadPool(2);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "Some result";
		}).thenApplyAsync(result -> {
			// Executed in a thread obtained from the executor
			return result + " from future in separate thread";
		}, executor);

		System.out.println(future.get());
	}
}
