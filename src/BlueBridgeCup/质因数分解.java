package BlueBridgeCup;

import java.util.Scanner;

public class 质因数分解 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		sc.close();
		printRange(start, end);
	}
	
	/**
	 * 处理范围内的所有数的质因数分解
	 */
	public static void printRange(int start, int end) {
		for (int i = start; i <= end; i++) {
			printPrimeFactors(i);
			System.out.println();
		}
	}
	
	/**
	 * 分解单个数的质因数
	 */
	public static void printPrimeFactors(int num) {
		System.out.print(num + "=");
		boolean first = true;	// 用于控制“*”符号的输出
		// 处理2这个特殊的质因子
		while (num % 2 == 0) {
			if(!first)
				System.out.print("*");
			System.out.print(2);
			num /= 2;
			first = false;
		}
		
		// 处理3即以上的奇数质因子
		for (int i = 3; i * i <= num; i += 2) {
			while (num % i == 0) {
				if(!first)
					System.out.print("*");
				System.out.print(i);
				num /= i;
				first = false;
			}
		}
		
		// 如果num仍然是一个大于2的质数，直接输出
		if (num > 2) {
			if (!first)
				System.out.print("*");
			System.out.print(num);
		}
	}
}
