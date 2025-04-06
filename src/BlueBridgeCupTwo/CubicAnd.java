package BlueBridgeCupTwo;

/**
 * @author guh
 * @description 
 * 153是一个非常特殊的数，它等于它的每位数字的立方和，即 153 = 111 + 555 + 333.编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class CubicAnd {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			int a = (i / 100) * (i / 100) * (i / 100);
			int b = ((i % 100) / 10) * ((i % 100) / 10) * ((i % 100) / 10);
			int c = (i % 10) * (i % 10) * (i % 10);
			if (i == (a + b + c)) {
//				System.out.println(i);
			}
		}
		System.out.println(5 * 5 * 5 + 3 * 3 * 3);
	}

}
