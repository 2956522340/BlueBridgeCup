package BlueBridgeCupThird;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		sc.close();
		for (int i = a; i >= 1; i--) {
			int p = i;
			while (p > 0) {
				System.out.print("* ");
				p--;
			}
			System.out.println();
		}
	}
}
