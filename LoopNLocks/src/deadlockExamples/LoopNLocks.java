package deadlockExamples;

import java.io.InvalidObjectException;


public class LoopNLocks {

	public static Object o;
	
	public static void main(String[] args) {
		
		try {
			String reason = "just because";
			divide(reason);
			divide(reason);
			throw new InvalidObjectException(reason);
		} catch (InvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			synchronized (e.getMessage()) {
				
			}
		}
		
	}
	
	public static int divide (String s) throws InvalidObjectException{
		throw new InvalidObjectException(s);
	}
}

class List{
	
	List next;
	
}