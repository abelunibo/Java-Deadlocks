public class Network {
	public void takeLocks(Object x, Object y) {
		synchronized (x) {
			synchronized (y) {

			}
		}
	}

	public void build(int n, final Object x, final Object y) {
		if (n == 0) {
			this.takeLocks(x, y);
		} else {
			final Object z = new Object();
			Thread thr = new Thread() {
				public void run() {
					takeLocks(x, z);
				}
			};
			thr.start();
			this.build(n - 1, z, y);
		}
	}

	public static void main(String[] args) {

		Network bn = new Network();
		Object x = new Object();		
		bn.build(1, x, x); // deadlock
		
		//Object y = new Object();
		//cd.BuildNetwork(1, x, y); // no deadlock
	}

}

