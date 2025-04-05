package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description
 * 带分数
 * 100 可以表示为带分数的形式：100 = 3 + 69258 / 714.
 * 还可以表示为：100 = 82 + 3546 / 197.
 * 注意特征：带分数中，数字1～9分别出现且只出现一次（不包含0）。
 * 类似这样的带分数，100有11种表示。
 * 输入格式
 * 从标准输入读入一个正整数N（N < 1000 * 2000)
 * 输出格式
 * 程序输出该数字用数码1～9不重复不遗漏地组成带分数表示的全部种数。
 * 注意：不要求输出每个表示，只统计有多少表示法！
 * 
 * 样例输入1
 * 100
 * 样例输出1
 * 11
 * 样例输入2
 * 105
 * 样例输出2
 * 6
 * 用深度优先搜索，将1～9形成一个全排序，根据整数部分、分子和分母的长度来分割整个排列。
 */
public class 写分数 {
	static int ans = 0; // 统计符合条件的带分数表示法的数量
	static int N = 0; // 输入的正整数

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 读取输入的正整数 N
		sc.close(); // 关闭扫描器

		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 数字 1 到 9 的数组
		f(0, arr); // 开始全排列的深度优先搜索
		System.out.println(ans); // 输出符合条件的带分数表示法的数量
	}
	
	// 全排列的深度优先搜索方法
	private static void f(int k, int[] arr) {
		if (k == 9) { // 当 k 达到 9，表示已经生成了一个完整的排列
			if (check(arr)) // 检查当前排列是否符合条件
				return; // 如果符合条件，返回
		}
		
		// 选定第 k 位进行全排列
		for (int i = k; i < arr.length; i++) {
			// 将第 i 个位置和第 k 位交换
			int t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
			
			f(k + 1, arr); // 递归调用，继续生成下一个位置的排列
			
			// 回溯（换回来）
			t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
		}
	}
	
	/**
	 * 枚举加号和除号的位置
	 */
	private static boolean check(int[] arr) {
		// + 前面的字符最多只能有 7 位，最后两位作为分子和分母
		for (int i = 1; i <= 7; i++) {
			int num1 = toInt(arr, 0, i); // 获取整数部分
			if (num1 >= N) // 如果整数部分已经超过 N，跳过
				continue;	
			
			// 枚举分子和分母的长度
			for (int j = 1; j <= 8 - i; j++) {
				int num2 = toInt(arr, i, j); // 获取分子
				int num3 = toInt(arr, i + j, 9 - i - j); // 获取分母
				System.out.println(num2);
				
				// 检查分子是否能被分母整除，并且是否满足带分数的条件
				if (num2 % num3 == 0 && N == num1 + num2 / num3) {
					// 检查 num1, num2, num3 是否使用了不同的数字
					if (isUnique(arr, 0, i, i + j, 9)) {
						ans++; // 统计符合条件的表示法
					}
				}
			}
		}
		return true; // 返回 true，表示检查完成
	}
	
	// 检查 num1, num2, num3 是否使用了不同的数字
	private static boolean isUnique(int[] arr, int start1, int end1, int start2, int end2) {
		boolean[] used = new boolean[10]; // 用于标记数字 1-9 是否被使用
		for (int i = start1; i < end1; i++) {
			used[arr[i]] = true; // 标记 num1 的数字
		}
		for (int i = start2; i < end2; i++) {
			if (used[arr[i]]) {
				return false; // 如果 num2 或 num3 中的数字已经被使用，返回 false
			}
			used[arr[i]] = true; // 标记 num2 或 num3 的数字
		}
		return true; // 所有数字都是唯一的
	}
	
	// TODO: 重点 & 难点
	// 将数组中的部分数字转换为整数
	private static int toInt(int[] arr, int pos, int len) { // pos当前处理的位， len为长度
		int t = 1; // 用于计算位数
		int ans = 0; // 存储转换后的整数
		for (int i = pos + len - 1; i >= pos; i--) {
			ans += arr[i] * t; // 计算当前位的值
			t *= 10; // 位数增加 -> 个位 -> 十位 -> 百位 -> ...
		}
		return ans; // 返回转换后的整数
	}
	
//	private static void print(int[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]);
//		}
//		System.out.println();
//	}
}
