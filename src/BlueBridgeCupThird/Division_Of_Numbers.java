package BlueBridgeCupThird;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 将整数n分成k份，且每份不能为空，任意两份不能相同(不考虑顺序)。
 * 	 例如：n=7，k=3，下面三种分法被认为是相同的。
 * 	 1，1，5; 1，5，1; 5，1，1;
 * 	 问有多少种不同的分法。
 */
public class Division_Of_Numbers {
	// 全局变量：用于记录合法划分 总数
	public static int cnt = 0;  
	/**
	 * 深度优先搜索函数（用于枚举所有合法的划分方式）
	 * @param front	当前要选的最小数字（用于保证每个数都不小于前一个，避免重复）
	 * @param n	当前剩下需要划分的总和
	 * @param step 当前还需要划分几个数字（还剩多少步）
	 */
	public static void dfs(int front, int n, int step) {
//		System.out.println(front + " " + n + " " + step);
		// 递归终止条件：‘只剩下最后一步（最后一个数）
		if(step == 1) {  
			// 因为前面已经保证了所有选择递增且不重复，所以最后一步直接统计一个合法的组合
	        cnt++;  
	        return ;  
	    }  
		// 遍历当前这一层可以尝试的所有值i 
		// i 从front开始，确保每次选择的数不小于前一次（保证不重复）
		// i <= n / step是一个剪枝条件：假设还要分step个数，那每个数最小要n/step（否则后面不够分）
	    for(int i = front; i <= n / step; i++) 
	    	// 递归进入下一层：选择了i，剩下n - i 要划分
	    	// 下一层的front也是i，确保不下降，避免重复组合
	        dfs(i, n - i, step - 1);  
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;  
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
	    dfs(1, n, k);
	    System.out.println(cnt);
	}
}