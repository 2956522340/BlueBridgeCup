package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 问题描述
 * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
 * 输入格式
 * 输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
 * 输出格式
 * 输出n行，每个m个字符，为你的图形。
 * 样例输入
 * 5 7
 * 样例输出
 * ABCD
 * BABC
 * CBAB
 * DCBA
 * EDCB
 */
public class LetterGraphic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int x[][] = new int[n][m];
		if (n <= m) {
			for (int i = 0; i < n; i++) {
				x[i][i] = 65;
				for (int j = i + 1; j < m; j++) {
					x[i][j] = x[i][j - 1] + 1;
				}
				for (int j = i - 1; j >= 0; j--) {
					x[i][j] = x[i][j + 1] + 1;
				}
			}
		} else {
			for (int i = 0; i < m; i++) {
				x[i][i] = 65;
				for (int j = i + 1; j < n; j++) {
					x[j][i] = x[j - 1][i] + 1;
				}
				for (int j = i - 1; j >= 0; j--) {
					x[j][i] = x[j + 1][i] + 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print((char)x[i][j]);
			}
			System.out.println();
		}
		
	}
}
