/**
 * 
 */
package deadlockExamples;


/**
 * @author Abel
 * Example of dynamic recursive method causing deadlock depending on
 * its arguments.
 */
public class BuildNetwork {

	/**
	 * Grabs in that order the locks of objects x and y
	 * @param x
	 * @param y
	 */
	public void TakeLocks(Object x, Object y) {
		synchronized (x) {
			synchronized (y) {

			}
		}
	}

	/**
	 * Recursively build a network with n elements
	 * if arguments @param x and @param y are equal
	 * this method produce a deadlock
	 * @param n: 
	 * 			the number of elements in the network
	 * @param x: 
	 * 			the first element in the network
	 * @param y: 
	 * 			the last element in the network
	 */
	public void build(int n, final Object x, final Object y) {
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
			this.build(n - 1, z, y);
		}
	}


	public static void main(String[] args) {

		BuildNetwork bn = new BuildNetwork();
		
		Object x = new Object();		
		bn.build(1, x, x); // deadlock
		
		//Object y = new Object();
		//cd.BuildNetwork(1, x, y); // no deadlock

	}

}
