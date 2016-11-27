
public class Tests {

	public static void main(String[] args){
		A a = new A();
		Object o = new Object();
		B b = new B();
		
		Tests t = new Tests();
		t.m1(a, o);
		t.m2(b, a);
		t.m3(a, o, o);
		t.m4(b,  o);
		
	}
	
	//Tests:
	//o1 is set in field FieldO1 of a
	//FieldO2 of a remains unknown/unchanged
	//original field FieldO1 is different from final effects on argument a
	//a's FieldO1 field is tagged with [w]
	public void m1(A a, Object o1){
		Object tmp = a.FieldO1;
		a.FieldO1 = o1;
		o1 = tmp;
	}
	
	
	//Tests:
	//the returned fresh object B has as fields original a argument and b.FieldO
	//b is updated with arg a and FieldO1 of a
	//b.FieldA, b.FieldO, A.FieldO1 are accessed in read mode
	//b.FieldA, b.FieldO ends with [w] tag
	public B m2(B b, A a){
		Object tmp = b.FieldO;
		B res = new B();
		
		b.FieldA = a;
		b.FieldO = a.FieldO1;
		
		res.FieldA = a;
		res.FieldO = tmp;
		
		return res;
	}
	
	//Tests:
	//a.FieldO2 is accessed in read
	//a.FieldO1 ends with [w] and value TOP
	public void m3(A a, Object o1, Object o2){
		if(a.FieldO2 != null){
			a.FieldO1 = o1;
		}else{
			a.FieldO1 = o2;
		}
	}
	
	//Tests
	//transitivity of field effects
	public void m4(B b, Object o){
		m4_1(b.FieldA, o);
	}
	
	public void m4_1(A a, Object o){
		a.FieldO1 = o;
	}
}

class A{
	
	public Object FieldO1, FieldO2;
	
}

class B{
	
	public A FieldA;
	public Object FieldO;
	
}
