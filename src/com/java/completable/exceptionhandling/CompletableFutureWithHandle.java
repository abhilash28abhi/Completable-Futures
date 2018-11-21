package com.java.completable.exceptionhandling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWithHandle {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// handle() is called whether or not an exception occurs

		Integer age = 25;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age can not be negative");
			}
			if (age > 18) {
				return "Adult";
			} else {
				return "Child";
			}
		}).handle((res, ex) -> {
			if (ex != null) {
				System.out.println("Oops! We have an exception - " + ex.getMessage());
				return "Unknown!";
			}
			System.out.println("In the handle method");
			return res;
		});

		System.out.println("Maturity : " + maturityFuture.get());
	}
}
