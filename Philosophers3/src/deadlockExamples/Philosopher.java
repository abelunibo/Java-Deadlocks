/**
 * 
 */
package deadlockExamples;

//import java.util.Random;


/**
 * @author Abel
 * Implementation of the classic philosophers problem with 3 Philosophers and 3 Forks
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
		
//		try{
//			Thread.sleep((long)random.nextFloat() * 1000);
//		} catch (InterruptedException e){
//			e.printStackTrace();
//		}
	}
	
	/**
	 * Eating process. During this method the object tries to acquire the locks
	 * of the corresponding forks (first the left one and then the right one).
	 * If both Forks can be locked the Philosopher can eat.
	 */
	private void eat(){
		synchronized(left){
			System.out.println(this + " took left fork no. " + left.getNumber());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			synchronized(right){
				System.out.println(this + " took right fork no. " + right.getNumber());
				System.out.println(this + " is eating");
//				try{
//					Thread.sleep((long)random.nextFloat() * 1000);
//				} catch (InterruptedException e){
//					e.printStackTrace();
//				}
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
	 * Entry point for the execution. This is where the deadlock takes place.
	 * The deadlock depends in the order the philosophers take the forks.
	 * @param args
	 */
	public static void main(String[] args) {

		Fork f0= new Fork(0);
		Fork f1= new Fork(1);
		Fork f2= new Fork(2);
		
		Philosopher d1 = new Philosopher(0,f2,f0); //Deadlock
		//Philosopher d1 = new Philosopher(0,f2,f0); //No Deadlock
		Philosopher d2 = new Philosopher(1,f0,f1); 
		Philosopher d3 = new Philosopher(2,f1,f2); 
		
		d1.start();
		d2.start();
		d3.start();
	}
	
//	public static void main(String[] args) {
//
//		Fork f0= new Fork(0);
//		Fork f1= new Fork(1);
//		
//		
//		Philosopher d1 = new Philosopher(0,f1,f0); //Deadlock
//		//Philosopher d1 = new Philosopher(0,f2,f0); //No Deadlock
//		Philosopher d2 = new Philosopher(1,f0,f1); 
//		 
//		
//		d1.start();
//		d2.start();
//		
//
//	}

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
