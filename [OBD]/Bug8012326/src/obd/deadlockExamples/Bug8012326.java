package obd.deadlockExamples;
/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */


import java.nio.charset.Charset;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Abel
 *
 */
public class Bug8012326 {

    public static void main(String[] args) throws Exception {
    	
    	
    	//deadlock between threads t1 and t2
//    			Thread t1 = new Thread() {
//    				public void run() {
//    					Charset.availableCharsets();
//    					//pause(10);
//    					System.out.println("Thread 1 completed");
//    				}
//    			};
//
//    			t1.start();

    			for (int i = 0; i < 1000; i++) {
    				final int current = i;
					Thread t2 = new Thread() {
						public void run() {
							Charset.availableCharsets();
							pause(1);
							System.out.println("Thread "+current+" completed");
						}
					};
					t2.start();
				}
				pause(1);
    			Charset.availableCharsets();    	    	
    			System.out.println("Thread Main completed");
    }

    public static void pause(int ms) {
        try {
			Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
}

