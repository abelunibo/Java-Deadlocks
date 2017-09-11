package deadlockExamples;

public class Test{
	
	public static void main(String[] args){
		
		final Object a = new Object(),b = new Object();
		
//		Thread t1 = new Thread(new A(a, b));
//		Thread t2 = new Thread(new A(b, a));
//		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				A r1 = new A(a, b);
				r1.run();
			}
		};


		Thread t2 = new Thread(){
			@Override
			public void run() {
				A r1 = new A(b, a);
				r1.run();
			}
		};
		
		
		t1.start();
		t2.start();
		
	}
}

class A implements Runnable{

	Object a,b;
	
	public A(Object a, Object b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void run() {
		synchronized (a) {
			synchronized (b) {
				
			}
		}
	}
	
}

//public class Test{
//	
//	public static void main(String[] args){
//		
//		Object a = new Object(),b = new Object();
//		for(int i = 0; i < 10; i++){
//			synchronized (a) {
//				synchronized (b) {
//					
//				}
//			}
//		}
//		
//	}
//}
////static constructors test
//public class Test {
//
//	static{
//		
//			System.out.println("from Test");
//		
//	}
//	
//	public static void main(String[] args){
//		A a = new A();
//		a.f(null);
//	}
//
//}
//
//class A{
//	static{
//		System.out.println("from A");
//	}
//	
//	public void f(B b){
//		System.out.println("from a.f");
//		
//	}
//}
//
//class B{
//	static{
//		System.out.println("from B");
//	}
//}

//fields updates test
//public class Test{
//	public static void main(String[] args){
//		
//		Object o = new Object();
//		
//		A a = getA(o);
//	}
//	
//	public static void updateA(A a, Object val){
//		a.f = val;
//	}
//	
//	public static A getA(Object o){
//		A a = new A();
//		
//		updateA(a, o);
//		
//		//a.f=o;
//		
//		return a;
//	}
//}

//public class Test{
//	private static long threadSeqNumber;
//
//	public static void main(String[] args){
//		long l = nextThreadID();
//		B b = new B();
//		long l2 = l + 1;		
//		b.f(10);
//	}
//	
//	public static void f(int i ) {
//		
//		f2(i);
//		
//	}
//	
//	public static void f2(int i ) {
//		
//		System.getenv();
//	}
//	
//	 private static synchronized long nextThreadID() {
//			return ++threadSeqNumber;
//		    }
//	
//	
//}
//
//abstract class A{
//	
//	public void f(int a){
//		Test.f(a);
//	}
//
//}
//
//class B extends A{
//	
//	
//
//}

//public class Test{
//	
//	public static Object a = new Object();	
//	
//	public static void main(String[] args){
//		final Thread t = new Thread(){
//			public void run() {
//				synchronized (a) {
//					try {
//						Thread.sleep(100);
//						a.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					this.suspend();
//				}
//			};
//		};		
//		
//		Thread t2 = new Thread(){
//			public void run() {
//				
//				synchronized (a) {
//					
//				}
//			};
//		};
//		
//		t.start();
//		t2.start();
//		
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		t.resume();
//		
////		try {
////			Thread.sleep(1000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
//}

//public class Test{
//	
//	public static Object a = new Object();	
//	
//	public static void main(String[] args){
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFileChooser fileChooser = new JFileChooser();
//	}
//}

//public class Test{
//	
//	public static Object a = new Object();	
//	public static Object b = new Object();	
//	
//	public static void main(String[] args){
//		final Thread t = new Thread(){
//			public void run() {
//				synchronized (b) {
//				synchronized (a) {
//					
//						Thread t2 = new Thread(){
//							public void run() {
//								
//								synchronized (b) {
//									a.notifyAll();
//								}
//							};
//						};
//						t2.start();
//						try {
//							a.wait();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				
//
//					
//				}
//				}
//			};
//		};		
//		
//		
//		
//		t.start();
//		
//	}
//}

//package deadlockExamples;
//
//public class Program {
//
//	public static void main(String[] args){
//		
//		Object a = new  Object();
//		Object b = new Object();
//				
//		Thread[] threads = new Thread[2];
//		
//		threads[0] = new Thread(){
//			@Override
//			public void run() {
//				synchronized ( a) {
//					
//				}
//			}
//		};
//		
//		startAll(threads);
//		
//		joinAll(a, threads);		
//	}
//
//	protected static void joinAll(Object a, Thread[] threads) {
//		for (int i = 0; i < threads.length; i++) {
//			synchronized (a) {
//				try {
//					threads[i].join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	protected static void startAll(Thread[] threads) {
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].start();
//		}
//	}
//	
//}
