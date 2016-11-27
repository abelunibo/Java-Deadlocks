package com.laneve.test.deadlocks;

public class SynchStaticMethod {

	public static synchronized void f(Object o) {
		synchronized (o) {

		}
	}

	public static void main(String[] args) {

		SynchStaticMethod sm = new SynchStaticMethod();
		final Object o = new Object();
		Object o2 = new Object();

		// deadlock between threads t1 and current
		Thread t1 = new Thread() {
			public void run() {
				SynchStaticMethod.f(o);
			}
		};

		t1.start();
		
		synchronized (o) {
			SynchStaticMethod.f(o2);
		}
	}

}
