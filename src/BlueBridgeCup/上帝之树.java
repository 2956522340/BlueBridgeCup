package BlueBridgeCup;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guh
 * @description
 * 在X森林里，上帝创造了生命之树。他给每棵树的每个节点（叶子也称为一个节点）上，都标了一个整数，代表这个点的和谐值。上帝要在这棵树内选出一个非空节点集S，
 * 使得对于S中任意两个点a，b，都存在一个点列{a, v1, v2, ...., vk, b} 使得这个点列都是S里面的元素，且序列中相邻两个点间有一条边相连。
 * 在这个前提下，上帝要使得S中的点对应的整数和尽量大，这个最大的和就是上帝给生命之树的评分。
 * 经过atm的努力，他已经知道了上帝给每棵树上的每个节点上的整数。但是由于atm不擅长计算，他不知道怎样有效的求评分。他需要你为他写一个程序来计算每一颗树的
 * 分数。
 * <p>
 * 输入格式
 * 第一行一个整数 n 表示这棵树有n个节点。第二行n个整数，依次表示每个节点的评分。
 * 接下来 n - 1行，每行 2 个整数u， v，表示存在一条u到v的边。由于这时一颗树，所以是不存在环的。
 * 输出格式
 * 输出一行一个数，表示上帝给这棵树的分数
 * <p>
 * 样例输入
 * 5 
 * 1 -2 -3 4 5
 * 4 2
 * 3 1
 * 1 2
 * 2 5
 * 样例输出
 * 8
 * 数据范围
 * 对于30%的数据， n <= 10
 * 对于100%的数据， 0 < n <= 10^5， 每个节点的评分的绝对值不超过 10^6
 * 
 * 评分（Weight）
 * 定义：每个节点（树的每个点）都有一个整数值，称为“评分”或“权重”（在代码中用 w[i] 表示）。
 * 作用：这个评分代表了该节点的特定价值或重要性。在树的上下文中，评分可以看作是该节点对整体树的贡献。
 * 示例：在样例输入中，节点的评分可能是正数或负数，表示该节点的价值。例如，评分为 4 表示该节点对树的贡献是正的，而评分为 -2 表示该节点的贡献是负的。
 * 和谐值（Harmony Value）
 * 定义：和谐值（在代码中用 dp[i] 表示）是通过计算树中某个节点及其子节点的评分总和得出的值。
 * 作用：和谐值表示以该节点为根的子树的总评分。它反映了从该节点出发，能够获得的最大评分。
 * 计算方式：和谐值是通过递归计算得出的，只有当子节点的和谐值为正时，才会将其加到父节点的和谐值中。这意味着和谐值只考虑对整体评分有正贡献的子树。     
 *    
 *        
 */
public class 上帝之树 {
	static int n;
	static long[] dp;
	static int[] w;
	static ArrayList<ArrayList<Integer>> tree;
	static long ans = 0;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 填充 0 索引 start
		w = new int[n + 1];		// weight
		dp = new long[n + 1];
		tree = new ArrayList<>();
		tree.add(new ArrayList<>());
		// 填充 0 索引 end
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			dp[i] = w[i];
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree.get(a).add(b);		// 无向边
			tree.get(b).add(a);
		}
		visited = new boolean[n + 1];
		dfs(1);		// 深度优先
		System.out.println(ans);
	}
	
	public static void dfs(int root) {
		visited[root] = true;		// 标记已处理
		for (int son : tree.get(root)) {
			if (!visited[son]) {		// 排除已处理的节点
				dfs(son);	// 继续递归子节点
				if (dp[son] > 0) {
					dp[root] += dp[son];
				}
			}
		}
		ans = Math.max(ans, dp[root]);
		// 回溯
		visited[root] = false;
	}
}
