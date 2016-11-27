/**
 * Example from:
 * http://stackoverflow.com/questions/27549671/how-to-diagnose-or-detect-deadlocks-in-java-static-initializers
 * @author Abel
 *
 */
public class StaticDeadlockExample extends Thread
{
    static
    {
    	f();
        Thread thread = new Thread(
                new StaticDeadlockExample(),
                "StaticDeadlockExample child thread");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    static void f(){
    	System.out.println("AAAA");
    }

    public static void main(String[] args)
    {
        System.out.println("in main");
    }

    public static void sayHello()
    {
        System.out.println("hello from thread " + Thread.currentThread().getName());
    }

//    @Override
//    public void run() {
//        StaticDeadlockExample.sayHello();
//    }
    
    @Override
    public void run() {
        while(true){
        	;
        }
    }
}