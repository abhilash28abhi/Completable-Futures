package com.java.completable.combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAnyOf {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 1";
		});

		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 2";
		});

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 3";
		});
		
		//anyOfFuture is completed when any of the three CompletableFutures complete
		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
		System.out.println(anyOfFuture.get());
	}
}
