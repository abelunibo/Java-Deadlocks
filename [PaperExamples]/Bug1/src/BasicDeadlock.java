public class BasicDeadlock {

	synchronized void foo(final int n, final Object a, final Object b)
			throws InterruptedException {

		Thread t = new Thread(new Runnable() {

			public void run() {
				if (n == 0) {
					synchronized (b) {
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
						}
						synchronized (a) {
							System.out.println("b-a");
						}
					}
				} else {
					synchronized (a) {
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
						}
						synchronized (b) {
							System.out.println("a-b");
						}
					}
				}
			}

		});

		Thread s = new Thread(new Runnable() {

			public void run() {
				if (n - 1 == 0) {
					synchronized (b) {
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
						}
						synchronized (a) {
							System.out.println("b-a");
						}
					}
				} else {
					synchronized (a) {
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
						}
						synchronized (b) {
							System.out.println("a-b");
						}
					}
				}
			}

		});
		t.start();
		s.start();
	}

	synchronized void gee(final int n, final Object a, final Object b)
			throws InterruptedException {

		Thread t = new Thread(new Runnable() {

			public void run() {
				if (n == 0) {
					synchronized (b) {
						synchronized (a) {
							System.out.println("b-a");
						}
					}
				} else {
					synchronized (a) {
						synchronized (b) {
							System.out.println("a-b");
						}
					}
				}
			}

		});

		Thread s = new Thread(new Runnable() {

			public void run() {
				if (n - 1 == 0) {
					synchronized (b) {
						synchronized (a) {
							System.out.println("b-a");
						}
					}
				} else {
					synchronized (a) {
						synchronized (b) {
							System.out.println("a-b");
						}
					}
				}
			}

		});
		t.start();
		s.start();
	}

	synchronized void huu(final int n, final Object a, final Object b)
			throws InterruptedException {

		Thread t = new Thread() {

			public void run() {
				if (n != 0) {
					synchronized (b) {
						synchronized (a) {
							synchronized (b) {
								System.out.println("b-a");
							}
						}
					}
				}

			}
		};

		Thread s = new Thread() {

			public void run() {
				if (n - 1 == 0) {
					synchronized (b) {
						synchronized (a) {
							synchronized (b) {
								System.out.println("a-b");
							}
						}
					}
				}
			}

		};
		t.start();
		s.start();
	}
	
	public static void luu(final Object a, final Object b){ 
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
	
	public static void luu3 (final Object a, final Object b, final Object c){
		synchronized (a) {
			synchronized (b) {
				
			}
		}
		
		synchronized (b) {
			synchronized (c) {
				
			}			
		}
		
		synchronized (c) {
			synchronized (a) {
				
			}			
		}
	}
	
	public static void starterRec(int n, final Object a, final Object b){
		if(n > 0){
			Thread t = new Thread(){
				public void run() {
					luu(a, b);
				};
			};
			
			t.start();
			starterRec(n - 1, a, b);
			
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void starterRec(int n, final Object a, final Object b, final Object c){
		if(n > 0){
			Thread t = new Thread(){
				public void run() {
					luu3(a, b, c);
				};
			};
			
			t.start();
			starterRec(n - 1, a, b, c);			
		}
	}

	
	public static void main(String[] args) {
//		BasicDeadlock x = new BasicDeadlock();
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
//		try {
//			x.huu(1, a, b);
//		} catch (InterruptedException e) {
//		}
		
		starterRec(3, a, b, c);
	}

}