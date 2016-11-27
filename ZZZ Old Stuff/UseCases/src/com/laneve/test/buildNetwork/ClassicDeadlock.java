package com.laneve.test.buildNetwork;

public class ClassicDeadlock {

	public void TakeLocks(Object x, Object y) {
		synchronized (x) {
			synchronized (y) {

			}
		}
	}

	public void BuildNetwork(int n, final Object x, final Object y) {
		if (n == 0) {
			this.TakeLocks(x, y);
		} else {
			final Object z = new Object();
			Thread thr = new Thread() {
				public void run() {
					TakeLocks(x, z);
				}
			};
			thr.start();
			this.BuildNetwork(n - 1, z, y);
		}
	}


	public static void main(String[] args) {

		Object x = new Object();
		Object y = new Object();
		ClassicDeadlock cd = new ClassicDeadlock();
		cd.BuildNetwork(1, x, x); // deadlock

	}
}

