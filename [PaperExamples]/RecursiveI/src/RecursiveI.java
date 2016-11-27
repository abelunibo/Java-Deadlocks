
public class RecursiveI {

	public static void main(String[] args) {
		
		Node n1 = buildList(10);
		
		//Node n1 = null; 
				
		Print(n1);
		Node inverted = ReverseList(n1);
		Print(inverted);
	}

	private static Node buildList(int n){
		if(n > 0){
			Node n1 = new Node(n, buildList(n-1));
			return n1;
		}
		return null;
	}
	
	private static void Print(Node inverted) {
		System.out.println(inverted.val);
		Print(inverted.next);
	}

	private static Node ReverseList(Node n1) {
		
		Node res;
		if(n1.next != null){
			res = ReverseList(n1.next);
			n1.next.next = n1;
			n1.next = null;
		}else{
			res = n1;
		}
		
		return res;
		
	}
	
	

}

class Node{
	public int val;
	public Node next = this;
	
	public Node(){
		val = 0;
	}
	
	public Node(int val, Node next){
		this.next = next;
	}
}
