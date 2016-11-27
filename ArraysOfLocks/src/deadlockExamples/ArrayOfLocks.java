package deadlockExamples;

public class ArrayOfLocks {

	// immutable
	public static final Object[] locks = new Object[]{/*a*/new Object(), /*b*/new Object()};
	
	
	//ghost states{{},{}}, threads{}
	public static void main(String[] args){
		
		Thread t0 = new Thread(){
			public void run() {
				Object locks0 = locks[0];
				synchronized (locks0) {
					//states{t0:{a}}
					Object locks1 = locks[1];
					synchronized (locks1) {
						//states{t0:{a}, t0:{a,b}}
					}
				}
			}
		};
		
		
		t0.start();
		//threads = {t0}
		
		
		
		Thread t1 = new Thread(){
			public void run() {
				Object locks1 = locks[1];
				synchronized (locks1) {
					//states{t0:{a},t0:{a,b}, t1:{b}}
					Object locks0 = locks[0];
					synchronized (locks0) {
						//states{t0:{a},t0:{a,b}, t1:{b}, t1:{b,a}}
					}
				}
			}
		};
		
		t1.start();
		//threads = {t0,t1}
	}
		
	

}
