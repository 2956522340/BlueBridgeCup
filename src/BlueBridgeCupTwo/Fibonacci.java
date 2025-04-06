package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 问题描述
 * Fibonacci数列的递推格式为：Fn + Fn - 1 + Fn - 2，其中F1 = F2 = 1；
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * 输入格式
 * 输入包含一个整数n。
 * 输出格式
 * 输出一行，包含一个整数，表示Fn除以10007的余数。
 * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能计出这个余数即可，而不需要先计算Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往
 * 比先原数在取余简单.
 * 样例输入
 * 10
 * 样例输出
 * 55
 * 样例输入
 * 22
 * 样例输出
 * 7704
 */
public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f1 = 1, f2 = 1, f3 = 0;
		sc.close();
		if (n < 3) {
			System.out.println(f1 + f2);
			return;
		}
		for (int i = 3; i <= n; i++) {
			if (f1 > 10007)f1 %= 10007;
			if (f2 > 10007)f2 %= 10007;
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		System.out.println(f3 % 10007);
	}

}
