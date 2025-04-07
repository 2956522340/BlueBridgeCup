package BlueBridgeCupThree;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 输入一个正整数n，输出n!的值。 其中n!=1*2*3*…*n。
 * 
 * 	n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。
 * 	使用一个数组A来表示一个大整数a，
 * 	A[0]表示a的个位，A[1]表示a的十位，依次类推。
 * 	将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
 * 	首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
 * 
 * 
 * 核心代码:
 * 
 *******************************************
 *******************************************

 for (int i = 2; i <= n; i++) {  
        int jw = 0;  
        for (int j = 0; j < a.length; j++) {  
            int temp = a[j] * i + jw;  
            a[j] = temp % 10;  
            jw = temp / 10;  
        }  
	}
	
 ********************************************
 ********************************************

 */
public class High_Precision_Vip {
    // 1000 ^ 1000 = 1 * 10^30
    public static int Array_Const = 3000; // 定义数组的最大长度
    public static int flag = 1; // 记录当前大数数组的最大位数(进位产生，默认为1)

 
  /*  
    // 获取数字的某一位
    public static int pre_digits(int y, int index) {
        for (int i = 0; i < index; i++) {
            y = y / 10; // 逐位除以10
        }
        return y % 10; // 返回当前位的数字
    }
    
    // 将数字转换为数组形式
    public static int[] number_to_array(int x, int n) {
        int a[] = new int[n]; // 创建数组
        int y = x; // 复制输入数字
        // 将数字的每一位存入数组
        for (int i = 0; i < n; i++) {
            a[i] = pre_digits(y, i); // 获取每一位
        }
        return a; // 返回数组
    }
    
    // 计算数字的位数
    public static int number_of_digits(int n) {
        String sn = String.valueOf(n); // 将数字转换为字符串
        return sn.length(); // 返回字符串的长度，即位数
    }
*/
    // 处理进位的函数
    /**
     * 
     * @param a
     * @param n
     * @return
     * a = [1]
     * n = 1 = nn, f = 0
     * 
     */
    public static int[] carry(int a[], int n) {
        int nn = n; // 当前有效位数
        int f = 0; // 进位标志
        for (int i = 0; i < nn + 1; i++) {		// 例如在执行n为个位时，做运算可能变成十位
            // 当当前位大于等于10时，进行进位处理
            while (a[i] >= 10) { // 如果大于等于10
                a[i] -= 10; // 减去10
                a[i + 1] += 1; // 下一个数组进一位
                // 更新最大位数
                if (i + 2 > flag) {
                    flag = i + 2;
                } 
                // 处理无限进位的情况
                if (i == nn && f == 0) {
                    ++nn; // 增加有效位数
                    f = 1; // 设置进位标志
                }
            }
            f = 0; // 重置进位标志
        }
        // 更新最大位数
        if (nn > flag) {
            flag = nn;
        }
        return a; // 返回处理后的数组
    }

    public static void main(String[] args) {
        // 读取输入的数字
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt(); // 输入的数字
        sc.close(); // 关闭扫描器
        long startTime = System.currentTimeMillis(); // 获取开始时间
        int b[] = new int[Array_Const]; // 创建数组用于存储大数
        b[0] = 1; // 初始化数组，表示1

        // 计算阶乘
        for (int i = 1; i <= a; i++) {
            for (int j = 0; j < flag; j++) {
                b[j] = b[j] * i; // 逐位乘以当前数字
            }
            b = carry(b, flag); // 处理进位
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        int pd = 1; // 用于跳过前导零的标志
        // 输出结果
        for (int k = flag; k >= 0; k--) {
            if (b[k] == 0 && pd == 1) {
                continue; // 跳过前导零
            }
            pd = 0; // 发现非零位
            System.out.print(b[k]); // 输出当前位
        }
        System.out.println(); // 换行
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms"); // 输出程序运行时间
    }
}