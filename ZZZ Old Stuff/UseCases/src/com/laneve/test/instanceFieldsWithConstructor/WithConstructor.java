package com.laneve.test.instanceFieldsWithConstructor;

// pc1 = monitorenter , pc2 = monitorenter

public class WithConstructor {
	private Object o;
	private Object o2;

	public WithConstructor(Object o, Object o2) {
		this.o = o;
		this.o2 = o2;
	}

	public void takelock() throws InterruptedException{
		synchronized (o) {
			synchronized (o2) {
			}
		}
	}

	public void takelock2() throws InterruptedException{
		synchronized (o2) {
			synchronized (o) {
			}
		}
	}

	public static void main(String[]args) throws InterruptedException{

		Object o = new Object();
		Object o2 = new Object();
		final WithConstructor d = new WithConstructor(o,o2);


		Thread t1 = new Thread(){

			@Override
			public void run() {
				try {
					d.takelock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				try {
					d.takelock2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
	}
}
