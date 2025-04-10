package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @Description: 输入一个正整数n,输出n!的值。其中n != 1 * 1 * 2 * 3 * ... * n。
 * 算法描述n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。
 * 使用一个数组A来表示一个大整数a,A[0]表示a的个位，A[1]表示a的十位，依次类推
 * 将a乘于一个整数k变为将数组A的每个元素都乘于k，请注意处理相应的进位。
 * 首先将a设置为1，然后乘于2，乘3，当乘到n时，即得到了n!的值
 */
public class Factorial_Calculation {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		// 创建一个整形的数组用于存放当前的每一位
		int[] arr = new int[9999];
		// 设置最开始的位置为1
		arr[0] = 1;
		// 阶乘从1开始算到n
		for (int i = 1; i <= n; i++) {	// 1 -> 2 -> 3 -> 4
			// 题目中描述的处理进位
			int carry = 0;
			/**
			 *  i = 1; j = 0 -> temp = 1 * 1 + 0 = 1; arr[0] = 1 % 10 = 1; carry = 0
			 *  i = 1; j = 1 -> temp = 0 * 1 + 0 = 0; arr[1] = 0 % 10 = 0; carry = 0
			 *  
			 *  i = 2; j = 0 -> temp = 1 * 2 + 0 = 2; arr[0] = 2 % 10 = 2; carry = 0;
			 *  
			 *  int temp = arr[j] * i + carry 配合carry = temp / 10来处理进位的问题 在arr中个位在0下标， 十位在1下标
			 */
			for (int j = 0; j < arr.length; j++) {		
				// 将a乘以一个整数k变为数组A的每一个元素都乘以k
				int temp = arr[j] * i + carry;
				arr[j] = temp % 10;		// 个位
				carry = temp / 10;		// 十位
			}
		}
		
		// 去掉之前的0
		int index = 0;
		for (int i = arr.length - 1; i >= 0; i --) {		// 数组长度要减一，因为数组是从0开始的
			if (arr[i] != 0) {
				index = i;
				break;
			}
		}
		
		// 找到第一个不为0的地方
		for (int i = index; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}
}
