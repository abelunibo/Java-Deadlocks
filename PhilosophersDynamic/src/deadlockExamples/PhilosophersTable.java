/**
 * 
 */
package deadlockExamples;

/**
 * @author Abel
 * Creates a dynamic table of Philosophers composed of n philosopher
 * where n may be an arbitrary argument. This example also makes use 
 * of an external dependency (classes Fork and Philosopher)
 */
public class PhilosophersTable {

	/**
	 * Creates a dynamic table of philosophers, recursively
	 * @param n: the number of philosophers to add to the table
	 * @param fl: current first fork
	 * @param fr: current last fork
	 * 
	 * This method behaves in the following way:
	 * if there is one last philosopher to put in the table (n==1)
	 * then this philosopher is added and the forks are assigned to him
	 * in the same order than in the arguments
	 * 
	 * otherwise, a new philosopher is created and sat in the last
	 * empty space of the table, the process continue recursively 
	 * until there is only one remaining spot.
	 */
	public void createTable(int n, Fork fl, Fork fr){
		if(n == 1){
			Philosopher p1 = new Philosopher(n, fl, fr);
			p1.start();
		} else {
			Fork fll = new Fork(n);
			Philosopher p = new Philosopher(n, fll, fr);
			p.start();
			createTable(n-1, fl, fll);
		}
	}
	
	/**
	 * Launches the philosopher table program. 
	 * NOTICE: if the last philosopher (pn below)
	 * grabs the forks in the opposite order
	 * then there is not a deadlock
	 * @param args
	 */
	public static void main (String[] args){
		int n = 10;
		Fork f1 = new Fork(1); 
		Fork fn = new Fork(n);
		Philosopher pn = new Philosopher(n, fn, f1); //with deadlock
		//Philosopher pn = new Philosopher(n, f1, fn); //without deadlock
		pn.start();
		
		PhilosophersTable table = new PhilosophersTable(); 
		table.createTable(n-1, f1, fn);
	}
}
