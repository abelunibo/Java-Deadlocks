
public class Test {

	public static void main(String[] args) {

		Thread t1 = new ThreadA();
		poly(t1);
		
		ThreadA t2 = new ThreadA();
		nonPoly(t2);
	}

	
	public static void nonPoly(ThreadA t){
		t.start();
	}
	
	public static void poly(Thread t){
		t.start();
	}
}
