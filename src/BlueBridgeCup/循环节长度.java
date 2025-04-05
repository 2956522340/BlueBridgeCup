package BlueBridgeCup;

import java.util.Vector;

/**
 * @author guh
 * @description 
 * 循环节长度
 * <p>
 * 两个整数做除法，有时会产生循环小数，其循环部分称为：循环节。
 * 比如，11/13=6=>0.846153846153.... 其循环节为[846153]共有6位。
 * 下面的方法，可以求出循环节的长度。
 * <p>
 * 请仔细阅读代码，并填写划线部分缺少的代码。
 * <p>
 * public static int f(int n , int m) {
 * 		n = n % m;
 * 		Vector v = new Vector();
 * <>
 * 		for (;;) {
 * 			v.add(n);
 * 			n *= 10;	// 110
 * 			n %= m;		// 110 % 13 =  6
 * 			if (n == 0) return 0;
 * 			if (v.indexOf(n) >= 0) {
 * 				---------------------
 * 			}
 * 		}
 * 	}
 * <p>
 * 注意，只能填写缺少的部分，不要重复抄写已有的代码。不要填写任何多余的文字。
 */
public class 循环节长度 {
	public static void main(String[] args) {
		int temp = f(11, 13);
		System.out.println(temp);
	}
	
	public static int f(int n, int m) {
		n %= m;
		Vector<Integer> v = new Vector<>();
		for (;;) {
			v.add(n);
			n *= 10;
			n %= m;
			if (n == 0) return 0;
			if (v.indexOf(n) >= 0) {
				return v.size() - v.indexOf(n);
			}
		}
	}
}
