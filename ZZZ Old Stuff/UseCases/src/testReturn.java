
public class testReturn {

	private Object someField;

	public int m(int l, Object o){
		
		Object a = o;
		Object b = a;
		this.someField = b;
		Object c = this.someField;
		
		synchronized (c) {
			synchronized (a) {
				
			}
		}
		
		if(l%2 == 0)
			return 1;
		return 10;
	}
	
}
