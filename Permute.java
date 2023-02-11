package task;

public class Permute {
	public static void main(String[] args) {
		String s = "abc";
		String result ="";
		printPermuteString(result,s);
	}

	public static void printPermuteString(String result,String str)
	{
		if(str.isEmpty())
		{
			System.out.println(result);
			return;
		}
		char ch=str.charAt(0);
		for(int i=0;i<=result.length();i++)
		{
			String first=result.substring(0,i);
			String second=result.substring(i,result.length());
			printPermuteString(first+ch+second,str.substring(1));
		}
	}


	
	
}
