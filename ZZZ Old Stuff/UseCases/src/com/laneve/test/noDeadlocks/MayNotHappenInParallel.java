package com.laneve.test.noDeadlocks;

public class MayNotHappenInParallel {

	public static void main(String[] args) throws InterruptedException {
		final Object a = new Object();
		final Object b = new Object();

		//no deadlock between threads t1 and t2
		//t1 and t2 never run in parallel
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					synchronized (b) {
					}
				}
			}
		};

		t1.start();
		t1.join();

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
