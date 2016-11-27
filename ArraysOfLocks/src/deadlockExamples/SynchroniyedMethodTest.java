package deadlockExamples;

public class SynchroniyedMethodTest {
	public static int main() {
		return magic();
	}
	
	public static synchronized int magic() {
		return 42;
	}
}
