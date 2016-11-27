package deadlockExamples;

public class RecType {
	
	RecType next;
	
	public void concat(RecType tail){
		if(next == null) next = tail;
		else{
			next.concat(tail);
		}
	}

	public static void main(String[] args) {
		RecType r = new RecType();
		RecType r2 = new RecType();
		
		r.concat(r2);
	}

}
