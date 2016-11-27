
/**
 * 
 */

/**
 * @author Abel
 * Implementation of the classic philosophers problem with an unbound number of philosophers
 */
public class Philosopher extends Thread{

	
	private int number;
	private Fork left, right;
//	private static Random random = new Random();
	
	/**
	 * Initializes a new instance of Philosopher
	 * @param number: the Id of the Philosopher
	 * @param left: the Fork at its left hand
	 * @param right: the Fork at its right hand
	 */
	public Philosopher(int number, Fork left, Fork right){
		this.number = number;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Simple string representation
	 */
	public String toString(){
		return "Fil no. " + number;
	}
	
	/**
	 * Thinking process, this happens right after eating
	 */
	private void think(){
		System.out.println(this.toString() + " is thinking");
	}
	
	/**
	 * Eating process. During this method the object tries to acquire the locks
	 * of the corresponding forks (first the left one and then the right one).
	 * If both Forks can be locked the Philosopher can eat.
	 */
	private void eat(){
		synchronized(left){
			System.out.println(this + " took left fork no. " + left.getNumber());
			synchronized(right){
				System.out.println(this + " took right fork no. " + right.getNumber());
				System.out.println(this + " is eating");
			}
		}
	}
	
	/**
	 * Implementation of the method run from class java.lang.Thread
	 */
	@Override
	public void run(){
		think();
		eat();
		this.run();
	}

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
		
		pn.createTable(n-1, f1, fn);
	}

}

class Fork{
	
	private int number;
	
	public Fork(int number){
		this.number = number;
	}
	
	public int getNumber(){
		return number;
	}
}
