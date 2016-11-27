/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */
package com.laneve.test.complications;

/**
 * @author Abel
 *
 */
public class A {

	A someA;
	
	public static void main(String[] args){
		A a = new A();
		m(a);
	}
	
	public static void m(A a){
		a.someA = new A();
		m(a.someA);
	}
	
	/* COMPLICATION RECUSIVE FIELDS
	 * public A parent;
	public A child;
	
	public A(){}
	
	public void setParent(A parent){
		this.parent = parent;		
	}
	
	
	
	
	public static void main(String[] args){
		A a = new A();
		A a2 = new A();
		a2.child = a;
		a.setParent(a2);
		
		//m(a);
	}

*/


//	/**
//	 * @param a
//	 */
//	private static void m(A a) {
//		synchronized (a) {
//			synchronized (a.parent) {
//				
//			}
//		}
//	}
}
