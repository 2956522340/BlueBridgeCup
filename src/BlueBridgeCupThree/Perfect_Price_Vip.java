package BlueBridgeCupThree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author guh
 * @description 
 * T 请你计算最少的交换次数使得该串变成一个完美的回文串。
 * 交换的定义是：交换两个相邻的字符
 * 例如mamad
 * 第一次交换 ad : mamda
 * 第二次交换 md : madma
 * 第三次交换 ma : madam (回文！完美！)
 * 
 * 输入格式
 * 第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
 * 第二行是一个字符串，长度为N.只包含小写字母
 * 
 * 输出格式
 * 如果可能，输出最少的交换次数。
 * 否则输出Impossible
 * 
 * 样例输入
 * 5
 * mamad
 * 
 * 样例输出
 * 3
 */
public class Perfect_Price_Vip {
	// 判断是否可以构成回文串
	public static String is_palindrome(String str, Integer a) {
		String rs = new String("");
		char[] chr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		// 统计每个字符出现的次数
		for (int i = 0; i < chr.length; i++) {
			Integer num = map.get(chr[i]);
			map.put(chr[i], num == null ? 1 : num.intValue() + 1);
		}
		Set<Character> set = map.keySet();
		Iterator<Character> it = set.iterator();
		//奇数串
		if (a.intValue() % 2 != 0) {
			int num = 0;
			while (it.hasNext()) {
				Character cr = it.next();
				if (map.get(cr) % 2 != 0) {
					num ++;
				}
			}
			if (num > 1) {
				rs = "Impossible";
			} else {
				rs = "Possible";
			}
		} else if (a.intValue() % 2 == 0) {
			//偶数串
			int num = 0;
			while (it.hasNext()) {
				Character cr = it.next();
				if (map.get(cr) % 2 != 0) {
					num ++;
				}
			}
			if (num > 0) {
				rs = "Impossible";
			} else {
				rs = "Possible";
			}
		}
		return rs;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		String str = sc.next();
		sc.close();
//		System.out.println(str);
		String rs = is_palindrome(str, a);
		int min;		// 最小交换次数
		char[] cr = str.toCharArray();
		if ("Impossible".equals(rs)) {
			System.out.println(rs);			// 如果不能构成回文，直接输出
			return;
		} else {
			min = 0;
			int middle = str.length() - 1;		// 右边界，用于控制右半边收缩
			int odd = 0;						// 用来标记是否遇到奇数个数的字符
			int oddside = -1;					// 记录那个奇数字符的位置
//			outside:
			// 从左边向右移动指针，处理每一对对称字符
			for (int i = 0; i <= middle; i++) {
				char c = cr[i];		// 当前要处理的字符
				int k = -1;			// 记录匹配字符在右边的位置
				// 从右边找和当前字符匹配的字符
				for (int j = middle; j > i; j--) {		// % 从后往前查找第一个出现的相同字符
					if (c == cr[j]) {
						k = j;
						break;
					}  
					// 如果走到最后都找不到匹配的字符
					if (j == i + 1) {
//						break outside;
						if (str.length() % 2 != 0) {		// 如果是奇数长度
							oddside = i;		// 把这个奇数字符放在中间
							odd++;  // odd -> 2 行212
						}
//						continue outside;
//						k = i;
						
					}
				} // for 2
				// 如果已经处理过一个奇数字符，就跳过这个
				if (odd == 1) {
					odd++;
					continue;
				}
				// 如果当前字符是最后一个
				if (i == middle) {
					k = i;
					if (oddside == -1) {
						oddside = i;
					}
				}
				int km = 0;		// 要移动的距离
				if (odd == 0) {		// 没有发现奇数的字符
					km = str.length() - 1 - i;  // ammna
				} else {
					if (odd == 2) {
						km = str.length() - i;
					}
				}
				// 把cr[k]的字符移到km的位置（一次次相邻交换）
				if (k <= km) {
					//k -> km
					char ck = cr[k];
					for (int p = k; p < km; p++) {
						cr[p] = cr[p + 1];
						min++;		 // 每次移动增加一次交换
					}
					cr[km] = ck;
					middle = km - 1;		// 每成功匹配一对，右边界向左缩
				}
			}  // for 1
			// 如果是奇数长度，还要把那个奇数字符移到中间
			if (str.length() % 2 != 0) {
					char c = cr[oddside];
					int l = 0;
					for (int p = oddside; p < str.length() / 2; p++) {
						cr[p] = cr[p + 1];
						min = min + 1;
						l = p;
					}
					cr[l + 1] = c;
					System.out.println(min);
					System.out.println(String.valueOf(cr));
					return;
			} else {
				System.out.println(min);
				System.out.println(String.valueOf(cr));
				return;
			}
		} //else
	}
}
