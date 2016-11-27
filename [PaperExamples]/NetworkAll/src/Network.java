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
			Locker thr = new Locker(this, x, z);
			thr.start();
			this.build(n - 1, z, y);
		}
	}

	public static void main(String[] args) {

		Network ntw = new Network();
		Object x = new Object();		
		ntw.build(1, x, x); // deadlock
		
		//Object y = new Object();
		//cd.BuildNetwork(1, x, y); // no deadlock
	}

}

class Locker extends Thread
 {
	final Network owner;
	final Object l1,l2;
	
	public Locker(Network ntw, Object x, Object y){
		owner = ntw;
		l1 = x;
		l2 = y;
	}
	
	public void run() {
		owner.takeLocks(l1, l2);
	}
}

