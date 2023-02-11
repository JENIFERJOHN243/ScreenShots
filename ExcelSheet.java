package task;

public class ExcelSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int columnNumber = 1;
		int quotient = columnNumber / 26;
	     int rem = columnNumber % 26;
	     char c = (char)('A'+(quotient-1));
	     char d = (char)('A'+(rem-1));
	     String s = String.valueOf(c);
	     String s1 = String.valueOf(d);
	     String ans = s.concat(s1);
	     System.out.println(ans);
	}

}
