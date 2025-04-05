package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 给定一个n * n大小的棋盘，棋盘中有些位置不能摆放皇后
 * 输入
 * 	输入的第一行为一个整数n，表示棋盘的大小
 *  接下来n行。每行n个0或则1的整数，如果一个整数为1，表示该位置可以摆放皇后，如果一个整数为0
 *  表示对应的位置不可以摆放皇后
 */
public class 皇后问题 {
	public static int total = 0;
	
	public static int N;
	public static int[] c;
	public static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		c = new int[N];
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		sc.close();
		solveNQueens(0);
		System.out.println(total);
	}
	// 递归求解N皇后问题
	public static void solveNQueens(int row) {
		if (row == N) {	// 所有行都放置成功
			total++;
			printBoard();
			return;
		}
		for (int col = 0; col < N; col ++) {	// 尝试在row行的每一列放皇后
			if (isSafe(row, col)) {
				c[row] = col;	// 记录皇后位置
				solveNQueens(row + 1);		// 递归放置下一行的皇后
			}	
		}
	}
	/**
	 * 1 1 1 1 -> row = 0 -> isSafe(0, {0, 1, 2, 3})
	 * 1 1 1 1
	 * 1 1 1 1
	 * 1 1 1 1
	 */
	// 检查在(row, col)位置放皇后是否合法
	public static boolean isSafe(int row, int col) {
		// 不能放在障碍物上
		if (board[row][col] == 0)
			return false;
		for (int i = 0; i < row; i++) {
			// 不能同列 ｜｜ 不能在同一条对角线 查找每行的皇后，c[i]为皇后的标记i行对应的列索引abs后面的表达式保证i行对应的列和本列的差
			if (c[i] == col || Math.abs(col - c[i]) == row - i) {	// rol当前尝试放皇后的位置 row当前尝试放皇后的行 row - i是当前行和已放置的
				// 第i行之间的行数差 col - c[i]是当前列和已放置的第i行皇后所在列的列数差
				return false;
			}
		}
		return true;
	}
	// 输出棋盘
	public static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (c[i] == j) {
					System.out.print("Q");
				} else if (board[i][j] == 0) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
