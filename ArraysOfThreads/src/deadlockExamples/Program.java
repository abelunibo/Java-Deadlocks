package deadlockExamples;

public class Program {

	public static void main(String[] args){
		
		Object a = new  Object();
		Object b = new Object();
				
		Thread[] threads = new Thread[2];
		
		threads[0] = new Thread(){
			@Override
			public void run() {
				synchronized ( b) {
					synchronized ( a) {
						
					}
				}
			}
		};
		

		
		threads[1] = new Thread(){
			@Override
			public void run() {
				synchronized ( a) {
					synchronized ( b) {
						
					}
				}
			}
		};
		
		
        threads[0].start();
        threads[1].start();
				
	}
	
}
