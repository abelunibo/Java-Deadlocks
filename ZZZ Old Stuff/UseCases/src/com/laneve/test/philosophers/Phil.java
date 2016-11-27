/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */
package com.laneve.test.philosophers;

/**
 * @author Abel
 *
 */
public class Phil extends Thread {
	Object left, right;	
	
	public Phil(Object l, Object r) {		
		this.left = l;
		this.right = r;
	}

	public void run() {
		synchronized (left) {
			synchronized (right) {
				//eat;
			}
		}		
	}
	
	public static void main(){
		Object c1 = new Object(), c2= new Object();                
		Phil p1 = new Phil(c1, c2);                     //     p2    
		Phil p2 = new Phil(c2, c1); //deadlock          //    /  \   
		//Phil p2 = new Phil(c1, c2); //no deadlock     //  c1    c2 
					 									//    \  /   
		p1.start();                                     //     p1    
		p2.start();		
	}
}


