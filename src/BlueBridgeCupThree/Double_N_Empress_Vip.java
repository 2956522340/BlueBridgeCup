package BlueBridgeCupThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。
 * 现在要向棋盘中放入n个黑皇后和n个白皇后，
 * 使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，
 * 任意的两个白皇后都不在同一行、同一列或同一条对角线上。
 * 问总共有多少种放法？n小于等于8。
 * 
 * 
 * 
 * 输入格式
 * 输入的第一行为一个整数n，表示棋盘的大小。
 * 接下来n行，每行n个0或1的整数，
 * 如果一个整数为1，表示对应的位置可以放皇后，
 * 如果一个整数为0，表示对应的位置不可以放皇后。
 * 
 * 输出格式
 * 输出一个整数，表示总共有多少种放法。
 * 
 * 
 * 样例输入
 * 4
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 样例输出
 * 2
 * 
 * 样例输入
 * 4
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 
 * 样例输出
 * 0
 * 
 * 
 *
 * 1 0 1 1
 * 1 1 1 0
 * 0 1 1 1
 * 1 1 0 1
 * 
 * 1 1 0 1
 * 0 1 1 1
 * 1 1 1 0
 * 1 0 1 1
 *
 *
 * object [][] array;
 * array.length 就是行数
 * array[0].length 就是列数
 */
public class Double_N_Empress_Vip {
    
    // 打印当前皇后放置方案
    public static void print(int b[]) {
        for (int i = 1; i < b.length; i++) {
            for (int j = 1; j < b.length; j++) {
                // 如果当前行的列数与 j 相等，打印 1，表示有皇后
                if (b[i] == j) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " "); // 否则打印 0
                }
            }
            System.out.println(); // 换行
        }
    }
    
    // 检查所有皇后的冲突数
    public static int judge2(List<int[]> l, int n) {
        int sum = 0; // 冲突计数
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.size(); j++) {
                if (i == j) {
                    continue; // 跳过同一方案
                }
                int a[] = l.get(i); // 获取第 i 个方案
                int b[] = l.get(j); // 获取第 j 个方案
                
                // 检查每一行是否有皇后在同一列
                for (int k = 1; k < n; k++) {
                    if (a[k] == b[k]) {
                        sum += 1; // 发现冲突，增加计数
                        break; // 退出循环
                    }
                }
            }    
        }
        return sum; // 返回冲突计数
    }
    
    // 检查当前放置是否有效
    public static boolean judge(int a[][], int b[], int k) { // k为当前行
        // 行: 根据算法，一行只放一个，故不需要判断 
        
        // 可否放位置判断
        if (a[k][b[k]] == 0) {
            return false; // 如果当前位置不能放皇后，返回 false
        }
        
        // 检查列和对角线
        for (int i = 1; i < k; i++) { // 遍历之前的行
            // 列:
            if (b[i] == b[k]) {
                return false; // 如果同一列，返回 false
            }
            // 对角线:
            if ((k - i) == Math.abs((b[k] - b[i]))) {
                return false; // 如果在同一对角线，返回 false
            }
        }
        
        return true; // 如果没有冲突，返回 true
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Integer a = sc.nextInt(); // 读取棋盘大小
        int k = a.intValue() + 1; // k 为棋盘的大小加 1
        
        int x[] = new int[k]; // 存储每行对应的列数
        int b[][] = new int[k][k]; // 棋盘状态数组
        
        List<int[]> list = new ArrayList<int[]>(); // 存储所有有效的放置方案
        
        // 读取棋盘状态
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                // 1可以放 0不可以放
                b[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        x[1] = 0; // 初始化，存储棋盘每行对应的列数
        
        int kw = 1; // 当前行
        int sum = 0; // 方案计数
        
        // 使用回溯法生成所有放置方案
        while (kw > 0) {
            x[kw] += 1; // 尝试放置下一个皇后
            
            // 检查当前行是否可以放置皇后
            while ((x[kw] <= a.intValue()) && !judge(b, x, kw)) { // 不能放时
                x[kw] += 1; // 尝试下一个列
            }
            
            if (x[kw] <= a.intValue()) {
                if (kw == a.intValue()) { // 如果放置完成
                    list.add(x.clone()); // 将当前方案添加到列表
                    // 当 x[kw] 超出有效范围（即没有可放置的列），则执行 kw--，表示当前行没有有效的放置方案。
                    // 这时，程序需要回溯到上一层（上一行），以便尝试在上一行的其他列放置皇后。
                    x[kw] = 0; // 回溯
                    kw--; // 返回上一层
                } else {
                    kw++; // 进入下一行
                    x[kw] = 0; // 初始化列数
                }
            } else {
            	// 当 kw 等于 a.intValue() 时，表示已经成功放置了所有的皇后（即当前行数等于棋盘的大小）。
            	// 在这种情况下，程序将当前的放置方案添加到 list 中，并重置当前行的列数 x[kw] 为 0。
            	// 然后，kw-- 被执行，表示回溯到上一层（上一行），以便尝试在该行的其他列放置皇后。
                kw--; // 回溯到上一层
            }        
        }
        
        // 计算冲突数
        sum = judge2(list, k);
        int rs = list.size() * (list.size() - 1); // 计算所有方案对的数量
        
        // 输出结果
        System.out.println(rs - sum); // 输出有效的放置方案数量
    }
}