package BlueBridgeCupThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。
 * 	 但是这种导弹拦截系统有一个缺陷：
 * 	 虽然它的第一发炮弹能够到达任意的高度，
 * 	 但是以后每一发炮弹都不能高于前一发的高度。
 * 	 某天，雷达捕捉到敌国的导弹来袭。
 * 	 由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
 * 
 * 
 * 输入格式
 * 一行，为导弹依次飞来的高度
 * 
 * 输出格式
 * 两行，分别是最多能拦截的导弹数与要拦截所有导弹最少要配备的系统数
 * 
 * 样例输入
 * 389 207 155 300 299 170 158 65
 * 样例输出
 * 6
 * 2
 * ----------------
 * 1门
 * 389 -> 388
 * 207 -> 206
 * 155 -> 154
 * require +1 
 * 300 -> 299
 * 170 -> 169
 * 158 -> 157
 * 65 -> 64
 * 由这里可以看出最少需要2个系统数
 * #其中“～>”为拦截后的下一发最低可以拦截的高度 “->“为下一发拦截的导弹的高度 
 * 389 ~> 388 -> 207(abandon) -> 155(abandon) -> 300 ~> 299 -> 299 ~> 298 -> 170 ~> 169 -> 158 ~> 157 -> 65 ~> 64
 * 
 */
public class Interceptor_Missile_Vip {
	
//	public static List<Integer> l = new ArrayList<Integer>();
//	public static int dp[][];
//	public static int max = 0;
//	public static int find_K(int i) {
//		int max = l.get(i);
//		int times = 0;
//		int index = i;
//		for (int j = i + 1; j < l.size(); j++) {
//			if (l.get(j) < max) {
//				if (dp[j][1] > times) {
//					times = dp[j][1];
//					index = j;
//				}
//			}
//		}
//		return index;
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str[] = br.readLine().split(" ");
//		for (int i = 0; i < str.length; i++)
//			l.add(Integer.valueOf(str[i]));
//		int time = 0;
//		while (!l.isEmpty()) {
//			dp = new int[l.size()][2];		// l.size()为
//			dp[l.size() - 1][0] = 0;
//			dp[l.size() - 1][1] = 1;
//			for (int i = l.size() - 2; i >= 0; i--) {
//				dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]);
////				System.out.println("dp[" + i + "][" + 0 + "]" + "=" + dp[i][0]);
//				int index = find_K(i);
////				System.out.println(index);
//				dp[i][1] = 1 + dp[index][1];
////				System.out.println("dp[" + i + "][" + 1 + "]" + "=" + dp[i][1]);
//			}
//			time ++;
//			if (time == 1) {
//				System.out.println(Math.max(dp[0][0], dp[0][1]));
//			}
//			List<Integer> l2 = new ArrayList<Integer>();
//			int mx = Integer.MAX_VALUE;
//			for (int i = 0; i < l.size(); i++) {
//				if (dp[i][1] >= dp[i][0] && l.get(i) < mx) {
//					mx = l.get(i);
//				} 
//				// 236 865 858 565 545 445 455 656 844 735 638 652 659 714 845
//				if (dp[i][1] < dp[i][0] || l.get(i) > mx) {
//					if (l.get(i) < mx && dp[i][1] < dp[i][0])
//						if (i - 1 >= 0 && dp[i][0] == Math.max(dp[i - 1][1], dp[i - 1][0]))
//							if (dp[i][1] != Math.min(dp[i - 1][1], dp[i - 1][0]))
//								continue;
//					l2.add(l.get(i));
//				}
//			}
//			l = l2;
//		}
//		System.out.println(time);
//	}
	// ------------------- 简易版本
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int[] missiles = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
	//	int[] missiles = Arrays.stream(input).mapToInt(s -> Integer.parseInt(s)).toArray();
		sc.close();
		
		// 第一问：最长不升子序列
		int[] dp = new int[missiles.length];
		int len = 0;		// 当前最长不升子序列长度
		
		/**
		 * 389 207 155 300 299 170 158 65
		 * missiles[i]		dp								len
		 * 389				[389]							1
		 * 207				[389, 207]						2
		 * 155				[389, 207, 155]					3
		 * 300				[389, 300, 155] 				3
		 * 299				[389, 300, 299] 				3
		 * 170				[389, 300, 299, 170]			4
		 * 158 				[389, 300, 299, 170, 158]		5
		 * 65				[389, 300, 299, 170, 158, 65]	6
		 */
		for (int i = 0; i < missiles.length; i++) {
			int left = 0, right = len;
			// 二分查找第一个 dp[mid] >= 当前导弹高度的位置
			while (left < right) {
				int mid = (left + right) / 2;
				if (dp[mid] >= missiles[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			// 将当前导弹高度放到对应位置（构建dp）
			dp[left] = missiles[i];
			// 如果当前导弹可以接在最长字序列后，扩展长度
			if (left == len) len++;
		}
		System.out.println(len);
		
		// 第二问
		// 贪心算法，每个系统维护一个末尾高度，每个导弹贪心放到能放的第一个系统
		List<Integer> systems = new ArrayList<Integer>();
		for (int h: missiles) {
			boolean placed = false;
			for (int i = 0; i < systems.size(); i++) { // 遍历systems，其中存放每个子序列的最小
				if (systems.get(i) >= h) {		// 用missiles中小的值来替换system大的值 ！注意，若发现h大于systems最小的值，则条件不通过，则会执行【1】中的条件语句，即往systems中追加元素
					systems.set(i, h);
					placed = true;
					break;
				}
			}
			if (!placed) systems.add(h);		// 【1】
		}
		System.out.print(systems.size());
	}
}