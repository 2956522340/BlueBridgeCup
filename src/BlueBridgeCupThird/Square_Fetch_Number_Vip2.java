package BlueBridgeCupThird;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 设有N*N的方格图(N<=10),我们将其中的某些方格中填入正整数,而其他的方格中则放入数字0。
 * 	 某人从图的左上角的A 点(1,1)出发，可以向下行走，也可以向右走，直到到达右下角的B点(N,N)。
 * 	 在走过的路上，他可以取走方格中的数（取走后的方格中将变为数字0）。
 * 	 此人从A点到B 点共走两次，试找出2条这样的路径，使得取得的数之和为最大。
 * 
 * 输入格式
 * 第一行一个正整数N，表示网络的边长
 * 接下来 若干行，每行包含三个整数x,y,z,表示在第x行第y列放置了一个值为z的正整数
 * 输入以一行0 0 0 结束
 * 
 * 输出格式
 * 输出一个整数，表示两次从(1, 1)到（N，N）所能取得的最大总和
 * 
 * 输入样例
 * 5
 * 1 2 3
 * 2 1 4
 * 2 3 6
 * 3 2 5
 * 4 4 8
 * 5 5 9
 * 0 0 0
 * 
 * 输出样例
 * 43
 * 样例说明
 * 第一次路径和第二次路径不能重复捡取同一个格子的值，但可以经过同一个格子，只不过只能在第一次中捡取，你需要设计出两条路径，使得总收益最大
 */
public class Square_Fetch_Number_Vip2 {
	// 这是一个四维数组，用于记录不同路径情况下的最大值
	public static int square[][][][] = new int[10][10][10][10];
	public static int n;
	public static int a[][] = new int[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (true) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			int a3 = sc.nextInt();
			if (a1 == 0 && a2 == 0 && a3 == 0) {
				break;
			}
			
			
			a[a1][a2] = a3;
		}
		sc.close();
		// 动态规划四层循环遍历所有的路径
		for (int i = 1; i <= n; i++){
			for (int j = 1; j <= n; j++){
				for (int k = 1; k <= n; k++){
					for (int l = 1; l <= n; l++){
						// 临时变量tmp用于记录当前路径的最大值
	                    int tmp = 0;
	                    // 比较四个可能的方向，选择最大的一个值
	                    tmp = Math.max(tmp, square[i - 1][j][k - 1][l]);
	                    tmp = Math.max(tmp, square[i - 1][j][k][l - 1]);
	                    tmp = Math.max(tmp, square[i][j - 1][k - 1][l]);
	                    tmp = Math.max(tmp, square[i][j - 1][k][l - 1]);
	                    // 如果当前i，j和k，z相等，说明我们只能从同一条方格出发，路径上只能选择一个方格
	                    if (i == k && j == l) {
	                    	// 选择当前格子的值
	                    	square[i][j][k][l] = tmp + a[i][j];
	                    }
	                    else {
	                    	// 否则，可以选择两个方格的值之和
	                    	square[i][j][k][l] = tmp + a[i][j] + a[k][l];
	                    }
	                }
	            }
	        }
	    }
		System.out.println(square[n][n][n][n]);
	}
}