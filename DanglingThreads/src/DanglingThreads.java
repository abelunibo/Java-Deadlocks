public class DanglingThreads {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		
		starterFoo(a, b);
		starterBar(a, b);
		
//		Thread t = new Thread(){
//			public void run() {
//				foo(a, b);
//			};
//		};
//		
//		t.start();
//		
//		Thread t2 = new Thread(){
//			public void run() {
//				bar(a, b);
//			};
//		};
//		
//		t2.start();
	}

	public static void foo(final Object a, final Object b) {
		synchronized (a) {
			synchronized (b) {

			}
		}		
	}
	
	public static void bar(final Object a, final Object b) {
		synchronized (b) {
			synchronized (a) {

			}
		}		
	}
	
	public static void luu(final Object a, final Object b) {
		synchronized (a) {
			synchronized (b) {

			}
		}

		synchronized (b) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			synchronized (a) {

			}
		}
	}

//	public static void starter(final Object a, final Object b) {
//		Thread t = new Thread(){
//			public void run() {
//				luu(a, b);
//			};
//		};
//		
//		t.start();
//	}
//	
	public static void starterFoo(final Object a, final Object b) {
		Thread t = new Thread(){
			public void run() {
				foo(a, b);
			};
		};
		
		t.start();
	}
	
	public static void starterBar(final Object a, final Object b) {
		Thread t = new Thread(){
			public void run() {
				bar(a, b);
			};
		};
		
		t.start();
	}

}
