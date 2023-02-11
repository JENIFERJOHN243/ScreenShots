package task;

public class StringImmutable {

	public static void main(String[] args) {
		getInput();
	}

	private static void getInput() {
		String string1="String";
		String string2="String";
		System.out.println("Before Concate");
		stringImmutable(string1,string2);
		string1 +="Immutable";
		System.out.println("After Concate");
		stringImmutable(string1,string2);
	}

	private static void stringImmutable(String string1, String string2) {
		if(string1==string2) System.out.println("Both reference are same");
		else System.out.println("Both reference are not same");
	}
}
