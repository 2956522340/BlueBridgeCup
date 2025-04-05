package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 按照要求进行回形取数
 */
public class 回形取数 {
	public static void main(String[] args) {
		int [][] x = {
				{4, 5, 6},
				{7, 8, 9}
				};
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();		// 2行		
		int n = sc.nextInt();		// 3列
		int [][] matrix = new int[m][n];
		// 依次写入到二维数组中
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		// 下面开始回形取数
		spairOrderPrint(matrix);
	}
	
	public static void spairOrderPrint(int[][] m) {
		int tR = 0;
		int tC = 0;
		int dR = m.length - 1;		// 行的末尾索引
		int dC = m[0].length - 1;	// 列的末尾索引
		while (tR <= dR && tC <= dC) {
			printEdge(m, tR++, tC++, dR--, dC--);
		}
	}
	
	/**
	 * 有两种特殊情况
	 * 1、只有一行
	 * 2、只有一列
	 */
	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// 只有一行的
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {	// 依次打印该行的所有列
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) {		// 只有一列
			for (int i = tR; i <= dR; i++) {		// 依次打每行的该列
				System.out.print(m[i][tC] + " ");
			}
		} else {
			int curR = tR;
			int curC = tC;
			// TODO 注意：每个循环操作的最后一个元素，留给下一循环操作，最后一个循环丢弃最后一个
			while (curR != dR) {		// dR为行的长度；curR为开始的行
				System.out.print(m[curR][tC] + " ");		// 打印第一列即[0][0], [1][0], [2][0], .., [n - 1][0]
				curR++;
			}
			while (curC != dC) {		// dC为列的长度；curC为开始的列
				System.out.print(m[dR][curC] + " ");		// 打印最后一行即[n][0], [n][1], [n][2], ..., [n][m - 1]
				curC++; 
			}
			while (curR != tR) {		// 
				System.out.print(m[curR][dC] + " ");		// 打印最后一列（反序）[n][m], [n - 1][m], [n - 2][m], ..., [1][m]
				curR--;
			}
			while (curC != tC) {
				System.out.print(m[tR][curC] + " ");		// 打印第一行（反序)[0][m], [0][m - 1], [0][m - 2], ..., [0][1]
				curC--;
			}
			
		}
	}
}
