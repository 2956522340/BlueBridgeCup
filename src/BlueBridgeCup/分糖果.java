package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
 * 每个小朋友 都把自己的糖果分一半给左手边的孩子。一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
 * 反复进行这个游戏。直到所有小朋友的糖果数都相同为止。你的任务是预测在已知的初始糖果的情形下，老师一共需要补发多少个糖果。
 * 程序首先读入一个整数N(2<N<100),表示小朋友的人数。
 * 
 * 接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）要求程序输出一个整数，表示老师需要补发的糖果数。
 * 例如：
 * 输入3 2 2 4 
 * 
 * 2 2 4 （初） 
 * 2 3 3 （平分）
 * 2 4 4 （奇加1）
 * 3 4 3 （平分）
 * 4 4 4 （奇加1）
 * 程序应该输出： 4
 */
public class 分糖果 {
	static int ans = 0;
	public static void main(String[] args) {
		// 这个一道迷你题目，先做糖果的分发，在做糖果的转移
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n;i ++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		while(check(arr)) {
			given(arr);
		}
		System.out.println(ans);
	}
	
	private static void given(int[] arr) {
		int cnt = arr[0] / 2;
		arr[0] /= 2;
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i] / 2;
			arr[i] /= 2;
			arr[i] += cnt;
			cnt = temp;
		}
		arr[0] += cnt;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				ans++;
				arr[i]++;
			}
		}
	}
	
	/**
	 * 判断当前是否还需要进行循环了
	 */
	public static boolean check(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] != 0) {
				return true;
			}
		}
		return false;
	}
}
