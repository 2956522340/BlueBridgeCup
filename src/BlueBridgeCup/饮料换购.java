package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 饮料换购
 * 乐羊羊饮料厂正在举办一次促销活动。乐羊羊C型饮料，凭3个瓶盖可以再换一片C型饮料，并且可以一直循环下去，但不允许赊账
 * 请你计算一下，如果小明不浪费瓶盖，尽量地参与活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。
 * 输入：一个整数n，表示开始购物的饮料数量（0 < n < 10000)
 * 输出：一个整数，表示实际得到的饮料数
 * 
 * 例如：
 * 用户输入：
 * 100
 * 程序应该输出：
 * 149
 * 
 * 用户输入：
 * 101
 * 程序应该输出：
 * 151
 * 
 * 
 */
public class 饮料换购 {
	
	private static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		ans = n;
		f(n);
		System.out.println(ans);
	}
	
	public static void f(int n) {
		if (n < 3) {
			ans += n;
			return;
		}
		int temp = n / 3;		// 能送多少瓶
		ans += temp; // 之前的总数 + 能送的数量
		f(temp);
	}
}
