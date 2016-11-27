import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * DAIS: Deadlock Analysis Italian Style
 * Type system based deadlock analysis technique for Java Bytecode
 */

/**
 * @author Abel
 *
 */
public class Test {

//	public static void main(String[] args) throws InterruptedException {
//		
//		Semaphore s = new Semaphore(0);
//		s.acquire();
//		
//	}
	
	 public static void main(String[] args) {
	     BigDecimal  quant;
	     int euro, cent;
	     Scanner keyboard = new Scanner(System.in) ;
	     quant = keyboard.nextBigDecimal();
	     euro = quant.intValue() ;
	     System.out.println(quant.subtract(new BigDecimal(euro)));
	   }
	
	public static void magic() {


		
	}
}
