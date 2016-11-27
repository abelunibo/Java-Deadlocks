package com.laneve.test.simpleWhile;

public class ClassicDeadlock {

	public static void main(String[] args) throws InterruptedException {

		Object a = new Object();
		Object temp = new Object();
		
		//deadlock between threads t1 and t2
		Thread t1 = new SomeThread(a, temp);

		t1.start();

		int i = 0;
		while(i++ > 0){
			Object tempTemp = new Object();
			//deadlock between threads t1 and t2
			Thread tempThread = new SomeThread(temp, tempTemp);
			tempThread.start();
			
			temp = tempTemp;			
		}
		
		
		Thread tLast = new SomeThread(temp, a);

		tLast.start();
		
		
		
	}
}

class SomeThread extends Thread{
	Object a, b;
	/**
	 * 
	 */
	public SomeThread(Object a, Object b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		synchronized (a) {
			synchronized (b) {
			}
		}
	}
}