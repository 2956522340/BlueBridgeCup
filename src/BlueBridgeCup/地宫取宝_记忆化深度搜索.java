package BlueBridgeCup;

import java.util.Scanner;

public class 地宫取宝_记忆化深度搜索 {
	private static long N = 1000000007;
	private static int n, m, k;
	private static int map[][] = new int[50][50];	//记录迷宫
	// dp中，四个参数各代表坐标x，y、手中持有宝物数量、手中宝物的最大值
	private static int dp[][][][] = new int[50][50][15][15];
	
	public static void init() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				for (int k = 0; k < 15; k++) {
					for (int l = 0; l < 15; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
	}
	
	public static int DFS(int x, int y, int num, int max) {
		// 记忆化搜索，首先检查该路径是否已经走过
		if (dp[x][y][num][max + 1] != -1) {
			// 说明已经走过这条路径，就不用在次走
			// 因为宝物有可能为0所以定义max时用最小值-1 这就导致无法作为下标使用
			// 实际上如果测试数据中宝物价值没有0，将所有的-1 去掉也是可以的
			// 这里的话如果去掉肯定是有些数据不对的，不信可以提交试一下，根本过不了
			return dp[x][y][num][max + 1];
		}
		// 到达边界
		if (x == n - 1 && y == m - 1) {
			/**
			 * 到达左下角有两种情况成功
			 * 1、当前手中的数量满足k，这时不拿会成功
			 * 2、当前手中的数量刚好差一个，然后地下的宝物大于手中的max，这时也会成功
			 */
			if (num == k || (num == k - 1 && max < map[x][y])) {
				return dp[x][y][num][map[x][y]] = 1;
			} else {
				return dp[x][y][num][max + 1] = 0;
			}
		}
		
		/**
		 * 拿和不拿的两种情况：
		 * 1、手中的max大于地下宝物价值，此时可拿可不拿
		 * 2、手中的max小于地下宝物价值，此时只能不拿
		 */
		long s = 0;
		if (x < n - 1) {	// 向下搜索
			if (max < map[x][y]) {		// 可拿可不拿，不拿的情况可以想成是不符合条件所以不拿，这样来说就可以将其和不能拿一起处理
				s += DFS(x + 1, y, num + 1, map[x][y]);
			}
			s += DFS(x, y + 1, num, max);		// 不拿，与不能拿时写一起，这点很重要！
			s %= N;
		}
		return dp[x][y][num][max + 1] = (int)s;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		init();
		DFS(0, 0, 0, -1);
		System.out.println(dp[0][0][0][0]);
	}
}
