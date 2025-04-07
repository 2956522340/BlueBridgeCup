package BlueBridgeCupThird;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 编写一个程序，首先输入一个整数，例如5，然后在屏幕上显示如下的图形（5表示行数）：
 * 
 * 	 * * * * *
 *   * * * *
 *   * * *
 *   * *
 *   *
 * 
 */
public class Graphic_Display {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		sc.close();
		for (int i = a; i >= 1; i--) {
			int p = i;
			while (p > 0) {
				System.out.print("*" + " ");
				p--;
			} 
			System.out.println();
		}
	}
}
