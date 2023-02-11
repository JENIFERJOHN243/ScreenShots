package task;

public class CricketScoreboard {

	public static void main(String[] args) {
		int i,j;
		String s="water";
		for(i=0;i<s.length();i++) {
			for(j=0;j<s.length();j++) {
				if(i==j||i+j==4||j==(s.length())/2) {
					System.out.print(s.charAt(i));
				}else if(i==(s.length())/2){
					System.out.print(s.charAt(j));
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
