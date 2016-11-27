package com.laneve.test.javaLib;

import java.util.concurrent.locks.*;
import java.lang.management.*;

public class Deadlock1 {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        Writer writer = new Writer();
//        sleep(10);
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

    static class Reader implements Runnable {
        public Reader() {
            new Thread(this).start();
        }
        public void run() {
            sleep(2);
            System.out.println("reader thread getting lock");
            lock.readLock().lock();
            System.out.println("reader thread got lock");
            synchronized (lock) {
                System.out.println("reader thread inside monitor!");
                lock.readLock().unlock();
            }
        }
    }

    static class Writer implements Runnable {
        public  Writer() {
            new Thread(this).start();
        }
        public void run() {
            synchronized (lock) {
                sleep(4);
                System.out.println("writer thread getting lock");
                lock.writeLock().lock();
                System.out.println("writer thread got lock!");
            }
        }
    }
}