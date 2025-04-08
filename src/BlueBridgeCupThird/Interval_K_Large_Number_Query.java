package BlueBridgeCupThird;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
 * 
 * 
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 2
 * 1 5 2
 * 2 3 2
 * 
 * 样例输出
 * 4  (3)
 * 2  (1)
 */
public class Interval_K_Large_Number_Query {
	
	// [0, size-1]
	public static int Quick_Sort(int a[], int low, int high) {
	    int pivot = a[low];
	    int i = low;
	    int j = high;
	    
	    /**
	     * {5, 3, 7, 6, 2, 8}
	     * pivot = 5
	     * i = 0 j = 5 找右边第一个 < 5 的，j从5到4 (j -> 4)
	     * a[4] = 2 < pivot, stop
	     * i = 0 j = 4 找左边第一个 > 5 的，i从0到2 (i -> 2)
	     * a[2] = 7 > pivot, stop
	     * {5, 3, 2, 6, 7, 8}
	     * 然后交换位置再重复操作....
	     */
	    while(i < j) {
	    	// 从右往左找小于pivot的
	    	while (i < j && a[j] >= pivot) j--;
	    	// 从左往右找大于pivot的
	    	while (i < j && a[i] <= pivot) i--;
	    	if (i < j) {
	    		// 交换a[i]和a[j]
	    		int tmp = a[i];
	    		a[i] = a[j];
	    		a[j] = tmp;
	    	}
	    }
	    //最后把pivot放到中间位置
	    a[low] = a[i];
	    a[i] = pivot;
	    
	    return i;	// 返回pivot最终的位置
	}
	
	  // 查找第k大的数
    public static int Findkth(int a[], int n, int k) {
        int low = 0;
        int high = n - 1;
        int pos = Quick_Sort(a, low, high); // 获取基准元素的位置  例pos = 2
        while (true) {
            if (n - k < pos) {
                pos = Quick_Sort(a, 0, pos - 1); // 在左半部分查找
            } else {
                if (n - k > pos) {
                    pos = Quick_Sort(a, pos + 1, high); // 在右半部分查找
                }
                if (n - k == pos) {
                    return a[pos]; // 返回第k大的数
                }
            }
        }
    }
	
	public static int[] CopyArrays(int a[], int left, int right) {
		int b[] = Arrays.copyOfRange(a, left, right + 1);  // left ~ right 不包含right - 1
		return b;
	}
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		int b[] = new int[a.intValue()];
		for (int i = 0; i < a.intValue(); i++) {
			b[i] = sc.nextInt();
		}
		Integer n = sc.nextInt();
		int c[][] = new int[n][3];
		for (int i = 0; i < n.intValue(); i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = sc.nextInt();
			}
			//32392 14605 3903 154 293 12383 17422 18717 19719 19896 5448 21727 14772 11539 1870 19913 25668
		}
		sc.close();
		long state_time = System.currentTimeMillis(); 
//		1 5 2
//		2 3 2
		
		for (int i = 0; i < n.intValue(); i++) {
			int p[] = CopyArrays(b, c[i][0] - 1, c[i][1] - 1);		// c[i][0] - 1, c[i][1] - 1为输入的数字的范围 b为数的数组		// copy是防止在排序时，意外导致原数组被修改
			System.out.println(Findkth(p, p.length, c[i][2]));		// c[i][2] 为要查到的第几位数
		}
		long end_time = System.currentTimeMillis();
		//1185000 ns  1704000ns 2498000ns
		System.out.println(end_time - state_time);
	}
}