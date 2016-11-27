package com.laneve.test.noDeadlocks;

public class Reentrance {

	public static void main(String[] args) throws InterruptedException {

		final Object a = new Object();
		
		//no deadlock re-entrance case
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					synchronized (a) {
					}
				}
			}
		};

		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				synchronized (a) {
					synchronized (a) {
					}
				}
			}
		};

		t2.start();
		
	}
}
