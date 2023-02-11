package task;

import java.util.Scanner;
import java.util.Stack;

public class PostFixExpression {

	public static void main(String[] args) {
		PostFixExpression postFix = new PostFixExpression();
		postFix.getInput();
	}

	private void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Expression");
		String expression = scanner.next();
		System.out.println(findPostfisExpression(expression));
	}

	private int findPostfisExpression(String expression) {
		Stack<Integer> stack = new Stack<>();
		for(int index=0;index<expression.length();index++) {
			char character = expression.charAt(index);
			if(Character.isDigit(character)) {
				stack.push(character-'0');
			}
			else {
				int value1 = stack.pop();
				int value2 = stack.pop();
				switch(character)
                {
                    case '+':{
                    stack.push(value2+value1);
                    break;
                    }
                    case '-':{
                    stack.push(value2- value1);
                    break;
                    }
                    case '/':{
                    stack.push(value2/value1);
                    break;
                    }
                    case '*':{
                    stack.push(value2*value1);
                    break;
                    }
              }
			}
		}
		return stack.pop();
	}
}
