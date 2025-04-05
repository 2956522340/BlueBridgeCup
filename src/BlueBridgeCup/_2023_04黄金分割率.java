package BlueBridgeCup;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author guh
 * @description 黄金分割数
 * 比较简单的一种用连分数：
 *  			 		1
 *  黄金数 = -------------------------------
 *  			    	1
 *  		 1  +  --------------
 *  					1
 *  			 1 + -----------
 *  					1
 *  			   1 + ---------
 *  					1 + ...
 *  这个连分数计算的"层数"越多，它的值越接近黄金分割数。
 *  请你利用这一特性，求出黄金分割数的足够精确值，要求四舍五入到小数点后100位；
 *  小数点后3位的值为：0.618
 *  小数点后4位的值为：0.6180
 *  小数点后5位的值为：0.61803
 *  小数点后7位的值位：0.6180340
 *  （注意尾部的0，不能忽略）
 *  你的任务是：写出精确到小数点后100位精度的黄金分割值
 */
public class _2023_04黄金分割率 {
	public static void main(String[] args) {
		/**
		 * 这是一道找规律的题目，由以上提示可以推出
		 * 第一层			1 / 1		-> 0
		 * 第二层			2 / 3		-> 1
		 * 第三层			3 / 5		-> 2
		 * 第四层			5 / 8		-> 3
		 * 第五层			8 / 13		-> 5
		 * 第六层			13 / 21		-> 8
		 * 第六层			21 / 34		-> 13
		 * .....
		 * 由上可以写出代码
		 */
		BigDecimal a = BigDecimal.ONE; // 初始化分子为1
		BigDecimal b = new BigDecimal("2"); // 初始化分母为2
		BigDecimal result = null; // 用于存储计算结果
		BigDecimal tmp; // 临时变量用于交换分子和分母
		for (int i = 0; i < 1000; i++) { // 迭代1000次以提高精度
			tmp = a; // 保存当前分子
			a = b; // 更新分子为当前分母
			b = tmp.add(b); // 更新分母为分子和分母的和
			// 这里直接放计算机去计算，要注意result的精确范围
			// result = a.divide(b, 1000, BigDecimal.ROUND_HALF_UP); // 计算黄金分割数
			result = a.divide(b, 1000, RoundingMode.HALF_UP);
		}
		// System.out.println(result.setScale(100, BigDecimal.ROUND_HALF_UP)); // 输出精确到小数点后100位的结果
		System.out.println(result.setScale(100, RoundingMode.HALF_UP));
	}
}
