package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 问题描述
 * 杨辉三角又称Pascal三角形，它的第哦i + 1行是（a + b）i的展开式的系数。
 * 它的一个重要性质是：
 * 三角形中的每个数字等于它两肩上的数字相加。
 * 下面给出了杨辉三角形的前4行：
 * 1
 * 11
 * 121
 * 1331
 * 给出n，输出它的前n行。
 * 输出格式
 * 输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分割。
 * 样例输入
 * 4
 * 样例输出
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 */
public class PascalTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int [][]x = new int[n][n];
		x[0][0] = 1;
		x[1][0] = 1;
		x[1][1] = 1;
		for (int i = 2; i < n; i++) {
			x[i][0] = 1;
			x[i][n - 1] = 1;
			for (int j = 1; j < n - 1; j++) {
				x[i][j] = x[i - 1][j] + x[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
}
