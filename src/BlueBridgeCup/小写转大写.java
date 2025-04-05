package BlueBridgeCup;

import java.util.Scanner;

public class 小写转大写 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		System.out.println(str.toUpperCase());
	}
}
