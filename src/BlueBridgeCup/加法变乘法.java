package BlueBridgeCup;

/**
 * @author guh
 * @description 
 * 加法变乘法
 * 我们都知道：1 + 2 + 3 + ... + 49 = 1225
 * 现在要求你把其中的两个不相邻的加号变乘号，使得结果为2015
 * 
 * 比如：
 * 1 + 2 + 3 + ... + 10 * 11 + 12 + ... + 27 * 28 + 29 + ... + 49 = 2015
 * 这就是符合要求的答案。
 * 请你寻找另外一个可能的答案，并把=位置靠前的那个乘号左边的数字提交（对于示范，就是提交10）。
 * 2015 - 1225 = 10 * 11 + 27 * 28 - 10 - 11 - 27 - 28
 * 790 = a * (a + 1) - a - (a + 1) + b * (b + 1) - b - (b + 1)
 * 790 = a^2 + a - a - a - 1 + b^2 + b - b - b - 1
 * 790 = a^2 - a + b^2 - b - 2
 */
public class 加法变乘法 {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i < 50; i++) {
			for (int j = 1; j < 50; j++) {
				if (i + 1 < j) {
					if (790 == (i * i - i + j * j - j - 2) && i != 10) {
						ans = i;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
