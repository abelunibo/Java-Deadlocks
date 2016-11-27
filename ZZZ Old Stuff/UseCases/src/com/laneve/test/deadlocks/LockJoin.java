package com.laneve.test.deadlocks;

public class LockJoin {

	public static void main(String[] args) throws InterruptedException {

		final Object a = new Object();
		
		//deadlock between threads t1 and t2
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					//...
				}
			}
		};

		synchronized (a) {
			t1.start();
			t1.join();
		}
	}

}
