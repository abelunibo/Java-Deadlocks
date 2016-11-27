package com.laneve.test.deadlocks;

public class SynchMethod {

	public synchronized void f(Object o) {
		synchronized (o) {

		}
	}

	public static void main(String[] args) {

		final SynchMethod sm = new SynchMethod();
		final Object o = new Object();

		// deadlock between threads t1 and current
		Thread t1 = new Thread() {
			public void run() {
				sm.f(o);
			}
		};

		t1.start();
		
		synchronized (o) {
			synchronized (sm) {
				//something
			}
		}
	}

}
