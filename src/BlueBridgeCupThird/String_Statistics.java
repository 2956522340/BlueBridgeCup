package BlueBridgeCupThird;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author guh
 * @description 
 * T 给定一个长度为n的字符串S，还有一个数字L，
 * 	 统计长度大于等于L的出现次数最多的子串（不同的出现可以相交），
 * 	 如果有多个，输出最长的，如果仍然有多个，输出第一次出现最早的。
 * 
 * 输入格式
 * 第一行一个数字L。
 * 第二行是字符串S。
 * L大于0，且不超过S的长度。
 * 输出格式
 * 一行，题目要求的字符串。
 * 
 * 输入样例1：
 * 4
 * bbaabbaaaaa
 * 输出样例1：
 * bbaa
 * 
 * 输入样例2：
 * 2
 * bbaabbaaaaa
 * 输出样例2：
 * aa
 * 
 * 数据规模和约定
 * n<=60
 * S中所有字符都是小写英文字母。
 */
public class String_Statistics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.close();
		// 获取字符串S的最长长度
		int max_n = str.length();	// 最大长度
		// 使用LinkedHashMap来存储字串及其出现的次数，LinnkedHashMap保证插入的顺序
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		// 遍历所有可能的字串长度，从n到max_n
		for (int i = n; i <= max_n; i++) {
			// 遍历字符串的每个字串，长度为i
			for (int j = 0; j + i <= max_n; j++) {
				// 获取字串
				String substring = str.substring(j, j + i);
				// 如果字串已经在map中，更新它的出现次数，否则初始化为1
				int v = map.get(substring) 
						== null ? 1 : map.get(substring) + 1;
				// 将字串及其出现次数放入map
				map.put(substring, v);
			}
		}
		// 获取map中所有条目的集合
		Set<?> set = map.entrySet();
		// 创建迭代器来遍历所有条目
	    Iterator<?> it = set.iterator();
	    // 记录出现次数最多的子串及其出现次数
	    int max = 0;		// 最大出现次数
	    String max_str = "";		// 记录最大出现次数的字串
	    // 遍历所有子串及其出现次数
	    while(it.hasNext()) {
	    	// 强制类型转换，获取当前条目（子串及其出现次数）
	    	@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> me = (Map.Entry<String, Integer>)it.next();
//	    	System.out.println(me.getKey() + " : " + me.getValue());
	    	// 如果当前字串的出现次数大于max，则更新max和max_str
	    	if (me.getValue() > max) {
	    		max = me.getValue();
	    		max_str = me.getKey();
	    	}
	    	// 如果当前子串的出现次数大于max，并且它的长度大于当前最大子串的长度，更新max_str为更长的子串
	    	if (me.getValue() == max 
	    			&& max_str.length() < me.getKey().length()) {
	    		max_str = me.getKey();
	    	}
	    }
	    System.out.println(max_str);
	}
}