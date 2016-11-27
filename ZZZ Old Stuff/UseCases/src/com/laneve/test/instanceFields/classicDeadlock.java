package com.laneve.test.instanceFields;

public class classicDeadlock {
	private Object o = new Object();
	private Object o_primo = new Object();

	public void takelock() {
		synchronized (o) {
			synchronized (o_primo) {
			}
		}
	}

	public void takelock2() {
		synchronized (o_primo) {
			synchronized (o) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		final classicDeadlock d = new classicDeadlock();

		Thread t1 = new Thread() {

			@Override
			public void run() {
				d.takelock();
			}
		};

		t1.start();

		Thread t2 = new Thread() {

			@Override
			public void run() {

				d.takelock2();

			}
		};

		t2.start();
	}
}
