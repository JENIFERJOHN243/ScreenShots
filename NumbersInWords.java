package task;

import java.util.Scanner;

public class NumbersInWords {

	public static void main(String[] args) {
		NumbersInWords numberWord = new NumbersInWords();
		numberWord.findNumbersInWords();
	}

	private void findNumbersInWords() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int inputNumber = scanner.nextInt();
		String[] oneDigits = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
		String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
		String answer = new String();
		if(inputNumber%100 <20){
		   answer = oneDigits[inputNumber%100];
		   inputNumber/=100;
		}
		else{
		   answer = oneDigits[inputNumber%10];
		   inputNumber/=10;
		   answer = tens[inputNumber%10]+" "+answer;
		   inputNumber/=10;
		}
		if(inputNumber==0) System.out.println(answer);
		else System.out.println(oneDigits[inputNumber]+" Hundred and "+ answer);
	}

}
