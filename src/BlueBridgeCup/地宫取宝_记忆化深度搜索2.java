package BlueBridgeCup;

import java.util.Scanner;

public class 地宫取宝_记忆化深度搜索2 {
	static int n, m, k; // 地宫的行数、列数和需要获取的宝物数量
	static int[][] data; // 存储地宫中每个格子的宝物价值
//	static int ans;
	static int MOD = 1000000007; // 结果取模的常量
	static long[][][][] cache; // 记忆化搜索的缓存数组
	// 先使用dfs进行搜索
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 读取行数
		m = sc.nextInt(); // 读取列数
		k = sc.nextInt(); // 读取需要获取的宝物数量
		data = new int[n][m]; // 初始化宝物价值数组

		// 读取地宫中每个格子的宝物价值
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// 初始化缓存数组，-1表示未计算
		cache = new long[51][51][14][14];
		for (int i = 0; i < 51; i++) {
			for (int j = 0; j < 51; j++) {
				for (int l = 0; l < 14; l++) {
					for (int o = 0; o < 14; o++) {
						cache[i][j][l][o] = -1; // 初始化缓存为-1
					}
				}
			}
		}

		// 从起点(0, 0)开始深度优先搜索
		long result = dfs(0, 0, -1, 0);
		System.out.print(result); // 输出结果
	}
	
	/**
	 * 深度优先搜索函数
	 * @param x 当前行坐标
	 * @param y 当前列坐标
	 * @param max 当前获取到物品中最大的值
	 * @param cnt 当前获取到的物品数量
	 * @return 当前路径下获取到的方案数
	 */
	private static long dfs(int x, int y, int max, int cnt) {
		// 如果超出边界，返回0
		if (x > data.length - 1 || y > data[0].length - 1) {
			return 0;
		}

		int cur = data[x][y]; // 当前格子的宝物价值
		int ans = 0; // 当前路径下的方案数

		// 如果到达右下角
		if (x == n - 1 && y == m - 1) {
			// 如果当前获取的物品数量等于k-1且当前物品价值大于max，返回1
			if (cnt == k || (cnt == k - 1 && cur > max)) 
				return 1;
			return ans; // 否则返回0
		}

		// 如果当前物品价值大于max，可以选择获取当前物品
		if (cur > max) {
			// 向下走
			ans += dfs(x + 1, y, cur, cnt + 1);
			// 向右走
			ans += dfs(x, y + 1, cur, cnt + 1);
		}

		// 对于价值较小的物品，或者价值不大于当前物品的最大值，继续探索
		ans += dfs(x + 1, y, max, cnt); // 向下走
		ans += dfs(x, y + 1, max, cnt); // 向右走

		// 将当前状态的结果存入缓存
		cache[x][y][max + 1][cnt] = ans % MOD;
		return ans; // 返回当前路径下的方案数
	}

}
