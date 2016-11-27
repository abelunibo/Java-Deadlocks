package com.laneve.test.noDeadlocks;

public class GuardedLocks {

	public static void main(String[] args) {
		final Object guard = new Object();
		final Object a = new Object();
		final Object b = new Object();

		//no deadlock between threads t1 and t2 because object guard avoids the circular dependency
		Thread t1 = new Thread() {
			public void run() {
				synchronized (guard) {
					synchronized (a) {
						synchronized (b) {
						}
					}
				}
			}
		};

		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				synchronized (guard) {
					synchronized (b) {
						synchronized (a) {
						}
					}
				}
			}
		};

		t2.start();
	}

}
