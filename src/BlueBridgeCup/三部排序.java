package BlueBridgeCup;

/**
 * @author guh
 * @description 三部排序
 * 一般的排序有许多经典算法，如快速排序、希尔排序等
 * 但实际应用时，经常会或多或少有一些特殊的要求。我们没必要套用那些经典算法，可以根据实际情况建立更好的解法。
 * 比如，对一个整形数组中的数字进行分类排序
 * 使得负数都靠左端，正数都靠右端，0在中部。注意问题的特点是：负数区域和正数区域并不要求有序，可以利用这个特点通过1次线性扫描就结束战斗！！
 * 以下的程序实现了该目标
 * 
 * 如果给定数组：
 * 25,18,-2,0,16,-5,33, 21,0,19,-16,25,-3,0		// element = 14 half = 7
 * 则排序后为：
 * -3,-2,-16,-5,0,0,0, 21,19,33,25,16,18,25
 * 
 * 1 -> ^0,18,-2,0,16,-5,33,21,0,19,-16,25,-3,{25}
 * 2 -> 0,^18,-2,0,16,-5,33,21,0,19,-16,25,-3,{25}
 * 3 -> 0,^-3,-2,0,16,-5,33,21,0,19,-16,25,{18,25}
 * 4 -> {-3},0,^-2,0,16,-5,33,21,0,19,-16,25,{18,25}
 * 5 -> {-3,-2},0,^0,16,-5,33,21,0,19,-16,25,{18,25}
 * 6 -> {-3,-2},0,0,^16,-5,33,21,0,19,-16,25,{18,25}
 * 7 -> {-3,-2},0,0,^25,-5,33,21,0,19,-16,{16,18,25}
 * 8 -> {-3,-2},0,0,^-16,-5,33,21,0,19,{25,16,18,25}
 * 9 -> {-3,-2,-16},0,0,^-5,33,21,0,19,{25,16,18,25}
 * 10 -> {-3,-2,-16,-5},0,0,^33,21,0,19,{25,16,18,25}
 * 11 -> {-3,-2,-16,-5},0,0,^19,21,0,{33,25,16,18,25}
 * 12 -> {-3,-2,-16,-5},0,0,^0,21,{19,33,25,16,18,25}
 * 13 -> {-3,-2,-16,-5},0,0,0,^21,{19,33,25,16,18,25}
 * 15 -> {-3,-2,-16,-5},0,0,0,{^21,19,33,25,16,18,25}
 */
public class 三部排序 {
	public static void main(String[] args) {
		int[] x = {25, 18, -2, 0, 16, -5, 33, 21, 0, 19, -16, 25, -3, 0};
		sort(x);
		for (int i : x) {
			System.out.print(i + "\t");
		}
	}
	  public static void sort(int[] x) {
	        int p = 0; // 当前指针，初始化为数组的起始位置
	        int left = 0; // 左指针，指向负数的结束位置
	        int right = x.length - 1; // 右指针，指向正数的开始位置

	        // 三部排序的核心逻辑
	        while (p <= right) {
	            if (x[p] < 0) {
	                // 如果当前元素是负数，将其交换到左边
	                int t = x[left]; // 保存左指针的值
	                x[left] = x[p]; // 将当前负数放到左指针位置
	                x[p] = t; // 将左指针的值放到当前指针位置
	                left++; // 左指针向右移动
	                p++; // 当前指针向右移动
	            } else if (x[p] > 0) {
	                // 如果当前元素是正数，将其交换到右边
	                int t = x[right]; // 保存右指针的值
	                x[right] = x[p]; // 将当前正数放到右指针位置
	                x[p] = t; // 将右指针的值放到当前指针位置
	                right--; // 右指针向左移动
	                // 注意：当前指针不移动，因为交换后的元素需要重新检查
	            } else {
	                // 如果当前元素是零，直接将其放到左指针的位置
	                int t = x[p]; // 保存当前零的值
	                x[p] = x[left]; // 将左指针的值放到当前指针位置
	                x[left] = t; // 将当前零的值放到左指针位置
	                p++; // 当前指针向右移动
	            }
	        }
	    }
}
