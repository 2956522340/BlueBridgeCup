package BlueBridgeCupTwo;

import java.util.Scanner;

public class SixTeenToEight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		sc.close();
		int x = Integer.parseInt(num, 16);		// 16转10
		System.out.println(Integer.toString(x, 8));	// 10转8
		
	}
}
