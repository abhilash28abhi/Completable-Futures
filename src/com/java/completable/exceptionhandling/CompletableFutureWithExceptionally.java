package com.java.completable.exceptionhandling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWithExceptionally {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// exceptionally() callback gives you a chance to recover from errors
		// generated from the original Future. You can log the exception here
		// and return a default value.

		Integer age = -1;
		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age can not be negative");
			}
			if (age > 18) {
				return "Adult";
			} else {
				return "Child";
			}
		}).exceptionally(ex -> {
			System.out.println("Oops! We have an exception - " + ex.getMessage());
			return "Unknown!";
		});
		System.out.println("Maturity : " + maturityFuture.get());
	}
}
