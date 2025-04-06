package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 问题描述
 * 1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 * 输出格式
 * 按从小到大的顺序输出满足条件的四位十进制数
 */
public class Palindrome4 {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			if (i / 1000 == i % 10 && (i / 100) % 10 == (i % 100) / 10) {
				System.out.println(i);
			}
		}
	}
}
