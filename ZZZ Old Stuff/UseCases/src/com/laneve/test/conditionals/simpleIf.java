/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */
package com.laneve.test.conditionals;

import com.sun.corba.se.spi.oa.OADefault;

/**
 * @author Abel
 *
 */
public class simpleIf {
	public static void main(String[] args){
		Object a;
		if(args.length == 2)
			a = new Object();
		else
			a = new Object();
		
		System.out.println(a.hashCode());
	}
}
