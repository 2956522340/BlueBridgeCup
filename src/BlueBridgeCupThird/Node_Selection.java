package BlueBridgeCupThird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 有一棵 n 个节点的树，树上每个节点都有一个正整数权值。
 * 	 如果一个点被选择了，那么在树上和它相邻的点都不能被选择。求选出的点的权值和最大是多少？
 * 
 * 
 * 输入格式
 * 第一行包含一个整数 n。
 * 接下来的一行包含 n 个正整数，第 i 个正整数代表点 i 的权值。
 * 接下来一共 n-1 行，每行描述树上的一条边。
 * 
 * 输出格式
 * 输出一个整数，代表选出的点的权值和的最大值。
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 样例输出
 * 12
 * 
 * 
 * 样例说明
 * 选择3、4、5号点，权值和为 3+4+5 = 12 。
 * 
 * 
 * 数据规模与约定
 * 对于20%的数据， n <= 20。
 * 对于50%的数据， n <= 1000。
 * 对于100%的数据， n <= 100000。
 * 权值均为不超过1000的正整数。
 */
public class Node_Selection {
	// 邻接表存储树结构
	public static Map<Integer, List<Integer>> tree;
	// dp[i][0]表示不选i，dp[i][1]表示选i
	public static int dp[][];
	
	public static void dfs(int current, int parent) {
		for (int child : tree.get(current)) {
			if (child != parent) {
				dfs(child, current);
				
				// 当前节点选了，子节点不能选
				dp[current][1] += dp[child][0];
				
				// 当前节点不选，子节点可选或不选，取较大值
				dp[current][0] += Math.max(dp[child][0], dp[child][1]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[n + 1][2];
		tree = new HashMap<Integer, List<Integer>>();
		
		// 初始化树结构与权值
		for (int i = 1; i <= n; i++) {
			tree.put(i, new ArrayList<Integer>());
			dp[i][1] = sc.nextInt();
		}
		
		for (int i = 1; i < n; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		sc.close();
		
		// 从根节点（假设为1）开始DFS
		dfs(1, -1);
		
		// 输出最大权值和（选或不选根节点)
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}
}