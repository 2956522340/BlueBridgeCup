package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * 问题描述
 * 123321是一个非常特殊的数，它从左边读和从右边读是一样的。
 * 输入一个正整数n，编程求所有这样的5位和6位十进制数，满足数字之和等于n。
 * 输入格式
 * 输入一行，包含一个正整数n。
 * 输出格式
 * 按从小到大的顺序输出满足条件的整数，每行整数占一行。
 * 样例输入
 * 52
 * 样例输出
 * 899998
 * 989989
 * 998899
 * 
 */
public class palindrome56 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for (int i = 10000; i < 1000000; i++) {
			if (i < 100000) {
				if (i / 10000 == i % 10 && (i / 1000) % 10 == (i % 100) / 10 && (i % 10) * 2 + (i % 100) / 10 * 2 + (i / 100) % 10 == n) {
					System.out.println(i);
				}
			} else {
				if (i / 100000 == i % 10 && (i / 10000) % 10 == (i % 100) / 10 && (i / 1000) % 10 == (i % 1000) / 100 && 
						(i / 100000) * 2 + ((i / 10000) % 10) * 2 + ((i / 1000) % 10) * 2 == n) {
					System.out.println(i);
				}
			}
		}
	}
}
