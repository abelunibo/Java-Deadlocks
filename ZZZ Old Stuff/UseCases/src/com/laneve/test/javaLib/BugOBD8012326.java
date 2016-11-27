/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */
package com.laneve.test.javaLib;

import java.nio.charset.Charset;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Abel
 *
 */
public class BugOBD8012326 {

    public static void main(String[] args) throws Exception {
    	//deadlock between threads t1 and t2
    			Thread t1 = new Thread() {
    				public void run() {
    					Charset.availableCharsets();
    				}
    			};

    			t1.start();

    			Thread t2 = new Thread() {
    				public void run() {
    					Charset.availableCharsets();
    				}
    			};

    			t2.start();
    }

    
}

