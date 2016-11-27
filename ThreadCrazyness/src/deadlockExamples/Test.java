package deadlockExamples;

public class Test {

	public static final Object a = new Object();
	public static final Object b = new Object();

	public static void main(String[] args) throws InterruptedException {
		m1();
	}

	/**
	 * This should deadlock since notify from t1 thread may happen before wait in main thread
	 * @throws InterruptedException
	 */
	public static void m1() throws InterruptedException {
		final Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					a.notify();
				}
			};
		};

		t1.start();
		synchronized (a) {
			a.wait();
		}
	}

	/**
	 * This should deadlock since wait from t1 thread may happen after notify in main thread
	 * @throws InterruptedException
	 */
	public static void m2() throws InterruptedException {
		final Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					try {
						a.wait();
					} catch (InterruptedException e) {
					}
				}
			};
		};

		t1.start();
		synchronized (a) {
			a.notify();
		}
	}

	/**
	 * This is not a deadlock since the synchronize block in main thread allows to reach 
	 * the wait instruction before the notify in thread 1
	 * @throws InterruptedException
	 */
	public static void m3() throws InterruptedException {
		synchronized (a) {
			final Thread t1 = new Thread() {
				public void run() {
					synchronized (a) {
						a.notify();
					}
				};
			};

			t1.start();
			a.wait();
		}
	}
	
	
	/**
	 * This is not a deadlock since the synchronize block in main thread allows to reach 
	 * the wait instruction before the notify in thread 1
	 * @throws InterruptedException
	 */
	public static void m3_1() throws InterruptedException {
		synchronized (a) {
			final Thread t1 = new Thread() {
				public void run() {
					synchronized (a) {
						synchronized (b) {
							a.notify();
						}						
					}
				};
			};

			t1.start();
			synchronized (b) {
				a.wait();
			}
			
		}
	}
	
	/**
	 * This is not a deadlock since t1 starts when main thread has already acquired lock b
	 * @throws InterruptedException
	 */
	public static void m4() throws InterruptedException {
		synchronized (a) {
			synchronized (b) {
			    Thread t1 = new Thread() {
					public void run() {
						synchronized (b) {
							synchronized (a) {
								System.out.println("from t1");
							}
						}
					};
				};
	
				t1.start();				
			}
		}
	}

}
