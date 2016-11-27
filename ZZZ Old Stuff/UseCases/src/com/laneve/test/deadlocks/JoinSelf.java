package com.laneve.test.deadlocks;

public class JoinSelf {

	public static void main(String[] args) throws InterruptedException {
		
		Thread.currentThread().join();

	}

}
