package BlueBridgeCup;

import java.util.*;

/**
 * @author guh
 * @description 
 * 标题：幸运数
 * 
 * 幸运数是波兰数学家乌拉姆命名的，它采用与生成素数类似的“筛选”生成
 * 首先从1开始写出自然数1，2，3，4，5，6....
 * 1就是第一个幸运数
 * 我们从2这个幸运数开始，把所有序号能被2整除的项删除，变为：
 * 1 _ 3 _ 5 _ 7 _ 9 ...
 * 把题目缩紧，重新排序，为：
 * 1 3 5 7 9 ....这时，3为第二个幸运数，然后把所有能被3整除的序号位置的数删去。注意，是序号位置，不是那个数本身能否被整除！！删除的应该是5，11，17....
 * 此时7为第3个幸运数，然后在删去序号位置能被7整数的（19，39，....)
 * 最后剩下的序列类似：
 * 1,3,7,9,13,15,21,25,31,33,37,43,49,51,63,67,69,,73,75,79,...
 * 本题要求：
 * 输入两个正整数mn，用空格分开（m < n < 1000 * 1000)
 * 程序输出 位于m 和n之间的幸运数的个数（不包含m和n）。
 * 
 *  例如：
 *  用户输入：
 *  1 20
 *  程序输出：
 *  5
 *  例如：
 *  用户输入：
 *  30 69
 *  程序输出：
 *  8
 *  资源约定：
 *  峰值内存消耗（含虚拟机） < 64M
 *  CPU消耗 < 2000ms
 *  
 */
public class 幸运数 {
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.MIN_VALUE);
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		List<Integer> current = new ArrayList<Integer>();
		current.add(1);
		int index = 2;
		int cur = list.get(index);		// 1 和 3必存在
		current.add(cur);
		while (cur != list.get(list.size() - 1)) {
			List<Integer> remove = new ArrayList<Integer>();
			for (int i = 1; i < list.size(); i++) {
				if (i % cur == 0) {
					remove.add(list.get(i));
				}
			}
			list.removeAll(remove);
			// index = 2
			for (int i = index; i < list.size(); i++) {
				if (!current.contains(list.get(i))) {		// 如果Current不包含list.get(i)
					cur = list.get(i);
					current.add(cur);
					index = i;
					break;
				}
			}
		}
		
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) > m && list.get(i) < n) {
				sum++;
			} else if (list.get(i) <= m) {
				break;	// 对应list.add(integer.MIN_VALUE)行
			}
		}
		System.out.println(sum);*/
		
		// 方式2
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < m; i += 2) {
			list.add(i);
		} // 偶数不用添加了
		int j = 2;	// 第二个幸运数
		
		while(list.get(j - 1) <= list.size()) {
			int number = list.get(j - 1);	//	幸运数
			for (int i = number - 1; i < list.size(); i = i + number - 1) { // number = 3 -> i = 2(1) -> i = 4(1) 前面number - 1是为了适配列表，更新条件 i + number - 1中的-1是因为前一个操作移除了一个元素 
				System.out.println(i);
				list.remove(i);
			}
			j++;
		}
		int temp = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= n) temp--;
		}
		if (list.contains(m)) temp--;
		System.out.println(temp);
	}
}
