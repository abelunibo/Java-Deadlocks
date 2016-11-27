package deadlockExamples;

public class SimpleWhile {
	
	public static void main(String[] args) throws InterruptedException {

		Object a = new Object();
		Object temp = new Object();

		// deadlock between threads t1 and t2
		Thread t1 = new SomeThread(a, temp);

		t1.start();

		int i = 10;
		while (i-- > 0) {
			Object tempTemp = new Object();
			// deadlock between threads t1 and t2
			Thread tempThread = new SomeThread(temp, tempTemp);
			tempThread.start();

			temp = tempTemp;
		}

		Thread tLast = new SomeThread(temp, a);

		tLast.start();

	}
	
	public static void g(){
		for(int i = 0; i < 10 ; i++){
			(new SomeThread(new Object(), new Object())).start();
		}
	}
	
	public static void h(){
		synchronized (new Object()) {
			System.out.println();
		}
	}
}

class SomeThread extends Thread {
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