package com.laneve.test.deadlocks;

public class ClassicDeadlock {

	public static void main(String[] args) throws InterruptedException {

		final Object a = new Object();
		final Object b = new Object();

		//deadlock between threads t1 and t2
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					synchronized (b) {
					}
				}
			}
		};

		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				synchronized (b) {
					synchronized (a) {
					}
				}
			}
		};

		t2.start();
		
		
		
	}
}
