package BlueBridgeCup;

/**
 * @author guh
 * @description 有理数就是可以表示两个整数的比值的数字，一般情况下，我们近似的小数表示，但是有时候不允许出现
 * 误差，必须用两个整数表示一个有理数
 * 
 * gcd 使用的方法欧几里得算法，是求两个数字之间的最大公约数
 * 
 * 有理数（Rational Number）是指可以表示为两个整数之比的数，
 * 其中分母不为零。形式上，有理数可以表示为：
 * 
 * a/b
 * 
 * 其中：
 * - a 是整数，称为分子（numerator）。
 * - b 是非零整数，称为分母（denominator）。
 * 
 * 特点：
 * 1. 可以表示为分数：有理数可以用分数的形式表示，例如 1/2、-3/4、5/1（等于 5）等。
 * 2. 包括整数：所有整数都是有理数，因为任何整数 n 都可以表示为 n/1。
 * 3. 包括有限小数和循环小数：有理数可以表示为有限小数（如 0.75）和循环小数（如 0.333...，表示 1/3）。
 * 4. 不包括无理数：无理数是不能表示为两个整数之比的数，例如 √2、π 和 e 等。
 * 
 * 示例：
 * - 有理数：
 *   - 1/2（分子为 1，分母为 2）
 *   - -3/4（分子为 -3，分母为 4）
 *   - 5（可以表示为 5/1）
 * 
 * - 无理数：
 *   - √2（不能表示为两个整数之比）
 *   - π（约等于 3.14159，不能用分数表示）
 * 
 * 总结：
 * 有理数是数学中非常重要的一类数，广泛应用于各种计算和理论中。
 * 它们的定义和性质使得有理数在数轴上是稠密的，即在任意两个有理数之间
 * 总可以找到另一个有理数。
 */
public class _2013_05有理数 {
	public static void main(String[] args) {
		// 创建两个有理数对象
		Rational a = new Rational(4, 7);
		Rational b = new Rational(1, 6);
		// 计算它们的和
		Rational c = a.add(b);
		System.out.println(a + " + " + b + " = " + c);
		
		// 计算它们的差
		Rational d = a.subtract(b);
		System.out.println(a + " - " + b + " = " + d);
	}
}

class Rational {
	private long ra; // 分子
	private long rb; // 分母
	
	// 计算最大公约数的欧几里得算法
	private long gcd(long a, long b) {
		if (b == 0) {
			return a; // 如果 b 为 0，返回 a
		}
		return gcd(b, a % b); // 递归调用
	}
	
	// 构造函数，初始化分子和分母，并进行约分 
	// ra 分子 rb 分母
	public Rational(long a, long b) {
		ra = a;
		rb = b;
		long k = gcd(ra, rb); // 计算最大公约数
		if (k > 1) { // 如果需要约分
			ra /= k; // 约分分子
			rb /= k; // 约分分母
		}
	}
	
	// 加法
	public Rational add(Rational x) {
		// 分子相加 分母相乘
		return new Rational(ra * x.rb + x.ra * rb, rb * x.rb); // 返回相加后的有理数
	}
	
	// 减法
	public Rational subtract(Rational x) {
		return new Rational(ra * x.rb - x.ra * rb, rb * x.rb); // 返回相减后的有理数
	}
	
	// 乘法
	public Rational mul(Rational x) {
		// 分子相乘 分母相乘
		// 4/7 * 1/6 = 4/42
		return new Rational(ra * x.ra, rb * x.rb); // 返回相乘后的有理数
	}
	
	// 除法
	public Rational div(Rational x) {
		// 分子相乘 分母相除
		// 4/7 / 1/6 = 24/7
		return new Rational(ra * x.rb, rb * x.ra); // 返回相除后的有理数
	}
	
	// 重写 toString 方法，方便输出
	@Override
	public String toString() {
		if (rb == 1) return "" + ra; // 如果分母为 1，直接返回分子
		return ra + "/" + rb; // 否则返回分数形式
	}
}
