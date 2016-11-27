/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */
package com.laneve.test.javaLib;
import java.util.concurrent.locks.*;
import java.lang.management.*;

public class Deadlock2 {

    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader(); reader.start();
        Writer writer = new Writer(); writer.start();
        sleep(10);
//        
//        System.out.println("finding deadlocked threads");
//        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
//        long[] ids = tmx.findDeadlockedThreads();
//        if (ids != null) {
//            ThreadInfo[] infos = tmx.getThreadInfo(ids, true, true);
//            System.out.println("the following threads are deadlocked:");
//            for (ThreadInfo ti : infos) {
//                System.out.println(ti);
//            }
//        }
//        System.out.println("finished finding deadlocked threads");
    }

    static void sleep(int seconds) {
        try {
            Thread.currentThread().sleep(seconds*1000);
        } catch (InterruptedException e) {}
    }
}

class Reader extends Thread {
    public void run() {
        Deadlock2.sleep(2);
        System.out.println("reader thread getting lock");
        Deadlock2.lock.readLock().lock();
        System.out.println("reader thread got lock");
        synchronized (Deadlock2.lock) {
            System.out.println("reader thread inside monitor!");
            Deadlock2.lock.readLock().unlock();
        }
    }
}

class Writer extends Thread {
    public void run() {
        synchronized (Deadlock2.lock) {
        	Deadlock2.sleep(4);
            System.out.println("writer thread getting lock");
            Deadlock2.lock.writeLock().lock();
            System.out.println("writer thread got lock!");
        }
    }
}
