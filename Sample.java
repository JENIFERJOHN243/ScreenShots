package task;

class A {
	void run (int a) {
		System.out.println("Hi");
	}
	static void run (int a) {
		System.out.println("hello");
	}
}

public class Sample {

	public static void main(String[] args) {
		A obj = new A();
		obj.run(1);
	}
}
