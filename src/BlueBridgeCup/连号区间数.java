package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 连号区间数
 * 小明这些天一直在思考这样一个奇怪而有趣的问题：
 * 在1～N的某个全排列中有多少个连号区间呢？这里所说的连号区间的定义是：
 * 如果区间[L, R] 里的所有元素（即此排列的第L个到第R个元素）递增排序后能得到一个长度为R - L + 1的“连续”数列，则称这个区间连号区间。
 * 当N很小的时候，小明可以很快地算出答案，但是当N变大的时候，问题就不是那么简单了，现在小明需要你的帮助。
 * 
 * 解题思路
 * for 循环遍历 N <= 50000
 * 
 * Max为当前循环找到的最大值
 * Min为当前循环找到的最小值
 * 
 * 如果Max - min = j - i
 * 就是答案
 */
public class 连号区间数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				if (max - min == j - i) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}
