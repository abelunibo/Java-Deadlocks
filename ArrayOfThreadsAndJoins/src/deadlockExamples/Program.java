package deadlockExamples;

public class Program {

	public static void main(String[] args){
		
		Object a = new  Object();
		Object b = new Object();
				
		Thread[] threads = new Thread[2];
		
		threads[0] = new Thread(){
			@Override
			public void run() {
				synchronized ( a) {
					
				}
			}
		};
		
		threads[0].start();
		
		synchronized (a) {
			try {
				threads[0].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}



