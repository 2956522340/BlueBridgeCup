package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 问题描述
 * 给出一个包含n个整数的数列，问整数a在数列中的第一次出现还是第几个。
 * 输入格式
 * 第一行包含一个整数n。
 * 第二行包含n个非负整数，为给定的数列，数列中的每个数都不大与10000；
 * 第三行包含一个整数a为待查找的数。
 * 输出格式
 * 如果a在数列中出现了，输出它第一次出现的位置（位置从1开始编号），否则输出-1.
 * 样例输入
 * 6
 * 1 9 4 8 3 9
 * 9
 * 样例输出
 * 2
 * 
 */
public class Locate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int num = sc.nextInt();
		sc.close();
		for (int i = 0; i < n; i++) {
			if (num == a[i]) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(-1);
		return;
	}
}
