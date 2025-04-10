package BlueBridgeCupThird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 给定一个n个顶点，m条边的有向图（其中某些边权可能为负，但保证没有负环）。
 * 	 请你计算从1号点到其他点的最短路（顶点从1到n编号）。
 * 
 * 输入格式
 * 第一行两个整数n, m。
 * 接下来的m行，每行有三个整数u, v, l，表示u到v有一条长度为l的边。
 * 
 * 输出格式
 * 共n-1行，第i行表示1号点到i+1号点的最短路。
 * 
 * 
 * 样例输入
 * 3 3
 * 1 2 -1
 * 2 3 -1
 * 3 1 2
 * 样例输出
 * -1
 * -2
 * 
 * 
 * 样例输入
 * 3 3
 * 1 2 -1
 * 2 3 -1
 * 3 1 2
 * 
 * 样例输出
 * -1
 * -2
 * 
 * 
 * 数据规模与约定
 * 对于10%的数据，n = 2，m = 2。
 * 对于30%的数据，n <= 5，m <= 10。
 * 对于100%的数据，1 <= n <= 20000，1 <= m <= 200000，-10000 <= l <= 10000，保证从任意顶点都能到达其他所有顶点。
 */

public class Shortest_Path {
	static final int INF = Integer.MAX_VALUE;		// 定义一个很大的值表示无穷大
	static List<int[]>[] g;		// 邻接表：每个顶点存放一个列表，列表里是[终点,权重]
	static int[] dist;		// 存放源点到每个点的最短距离
	static boolean[] inq;		// 标记某个点是否在队列中（避免重复入队）
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 顶点数量
		int m = sc.nextInt();		// 边数量
		
		g = new ArrayList[n + 1];		// 从1开始编号，开n+1大小
		for (int i = 0; i <= n; i++) {
			g[i] = new ArrayList<int[]>();
		}
		
		// 读入边信息
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();		// 起点
			int v = sc.nextInt();		// 终点
			int w = sc.nextInt();		// 权重
			g[u].add(new int[]{v, w});		// 添加有向边 u -> v,	权重为w
		}
		sc.close();
		
		// 初始化
		dist = new int[n + 1];
		inq = new boolean[n + 1];
		Arrays.fill(dist, INF);		// 初始所有点点距离设为无穷大
		dist[1] = 0;		// 源点到自己的距离为0
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); // 将源点加入队列
		inq[1] = true;		// 标记源点在队列中
		
		// SPEA主循环
		while (!q.isEmpty()) {
			int u = q.poll();		// 取出队头元素
			inq[u] = false;		// 标记u不在队列中
			
			for (int[] edge : g[u]) {
				int v = edge[0], w = edge[1];
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w; 		// 更新距离
					if (!inq[v]) {		// 如果v不在队列中
						q.offer(v);		// 入队
						inq[v] = true;
					}
				}
			}
		}
		// 输出从1到其他点的最短路
		for (int i = 2; i <= n; i++) {
			System.out.println(dist[i] == INF ? "INF" : dist[i]);
		}
	}
}


//public class Shortest_Path {
//	public static int INF = Integer.MAX_VALUE;
//	public static void Floyid(int P[][], int D[][]) {
//	for (int k = 1; k < P.length; k++) {
//			for (int i = 1; i < P.length; i ++) {
//				for (int j = 1; j < P.length; j++) {
//					 int tmp = (P[i][k]==INF || P[k][j]==INF) ? INF : (P[i][k] + P[k][j]);
//					 if (P[i][j] > tmp) {
//						 P[i][j] = tmp;
//						 D[i][j] = k;
//					 }
//				}
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		Integer a = sc.nextInt();
//		Integer b = sc.nextInt();
//		sc.close();
//		int P[][] = new int[a + 1][a + 1];
//		int D[][] = new int[a + 1][a + 1];
//		for (int i = 1; i < a + 1; i ++) {
//			for (int j = 1; j < a + 1; j++) {
//				if (i != j) {
//					P[i][j] = INF;
//				}
//				D[i][j] = j;
//			}
//		}
//		for (int i = 0; i < b; i++) {
//			Integer u = sc.nextInt();
//			Integer v = sc.nextInt();
//			Integer w = sc.nextInt();
//			P[u][v] = w;
//		}
//		Floyid(P, D);
//		for (int i = 1; i < a; i++) {
//			System.out.println(P[1][i + 1]);
//		}
//	}
//}