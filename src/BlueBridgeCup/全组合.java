package BlueBridgeCup;

/**
 * @author guh
 * @description 基本思路：求全组合，假设由原来的元素有n个，最终组合的结果为2^n个
 * 使用的是位操作
 * 
 * 假设原来的元素为 {"a", "b", "c"}
 * 全组合的为 {"a", "b", "c", "ab", "ac", "bc", "abc"}
 * 对应的结果是 100 010 001 110 101 011 111
 * 所以结果是 0 ～ 2^n - 1
 */
public class 全组合 {
	public static void main(String[] args) {
		String[] str = {"a", "b", "c"};
		int n = str.length;
		int nbit = 1 << n;		// (1)
		System.out.println("全组合个数：" + nbit);
		for (int i = 0; i < nbit; i++) {
			for (int j = 0; j < n; j++) {
				int temp = 1 << j;		// temp -> {1, 2, 4}/{0001, 0010, 0100} //(2)
				// (temp & i) != 0 的作用是判断当前组合 i 是否包含数组 str 中的第 j 个元素。
				// 如果包含，则打印该元素。通过这种方式，代码能够生成并打印出所有可能的组合。
				if ((temp & i) != 0) {	
					System.out.print(str[j]);
				}
			}
			System.out.println();
		}
	}
}
