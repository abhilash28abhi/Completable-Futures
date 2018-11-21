package com.java.completable.combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Rule of thumb here - If your callback function returns a CompletableFuture,
 * and you want a flattened result from the CompletableFuture chain (which in
 * most cases you would), then use thenCompose()
 *
 */
public class CompletableFutureThenCompose {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String original = "Message";
		CompletableFuture<String> cf = CompletableFuture.completedFuture(original).thenApply(s -> s.toUpperCase())
				.thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(s -> s.toLowerCase())
						.thenApply(s -> upper + " " + s));

		System.out.println(cf.get());
	}
}