package BlueBridgeCupThird;

import java.util.Scanner;
import java.util.Stack;

public class Postfix_Expression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] tokens = sc.nextLine().split(" ");
		Stack<Integer> stack = new Stack<Integer>();
		sc.close();
		for (String token : tokens) {
			if (isOperator(token)) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(applyOperator(token, a, b));
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		System.out.println(stack.pop());
	}
	
	public static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}
	
	public static Integer applyOperator(String str, int a , int b) {
		switch (str) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case  "*":
			return a * b;
		case "/":
			return a / b;
		}
		return 0;
	}

}
