package BlueBridgeCup;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 垒骰子
 * 赌圣atm晚年迷上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。 
 * 经过长期观察，atm发现了稳定骰子的奥秘：有些数字的面贴着会相互排斥！
 * 我们先来示范一下骰子：1的对面是4， 2 的对面是5， 3的对面是6。
 * 假设有m组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。
 * atm想计算一下有多少种不同的可能的垒骰子方式
 * 两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同
 * 由于方案可能很多，输出10^9 + 7 的结果
 * <p>
 * 不要小看垒atm的骰子数量哦～
 * <p>
 * 输入格式
 * 第一行两个整数n m
 * n表示骰子数目
 * 接下来m行，每行两个整数a b，表示a 和 b 不能紧贴在一起。
 * <p>
 * 输出格式
 * 一行一个数，表示答案模 10^9 + 7 的结果
 * <p>
 * 样例输入
 * 2 1
 * 1 2
 * <p>
 * 样例输出
 * 544
 * <p>
 * 数据范围
 * 对于 30% 的数据： n <= 5
 * 对于 60% 的数据： n <= 100
 * 对于 100% 的数据： 0 < n <= 10^9, m <= 36
 */
public class 垒骰子 {
    static int MOD = 1000000007; // 结果取模的常量
    static int[] op = new int[7]; // 存储每个数字的对面数字
    static boolean[][] conflict = new boolean[7][7]; // 冲突数组，表示哪些数字不能相邻

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 骰子的层数
        int m = sc.nextInt(); // 冲突的数量

        // 读取冲突对并更新冲突数组
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(); // 冲突的第一个数字
            int y = sc.nextInt(); // 冲突的第二个数字
            conflict[x][y] = true; // 标记冲突
            conflict[y][x] = true; // 冲突是双向的
        }
        sc.close();

        init(); // 初始化对面数字的关系
        long ans = 0;

        // 遍历所有可能的上面朝上的数字
        for (int up = 1; up <= 6; up++) {
            ans = (ans + 4 * f(up, n - 1)) % MOD; // 计算每种情况下的可能性
        }

        System.out.println(ans); // 输出结果
    }

    /**
     * 递归函数，计算在给定上面数字和剩余层数下的可能性
     * @param up 当前层的上面数字
     * @param cnt 剩余的层数
     * @return 当前状态下的可能性
     */
    public static long f(int up, int cnt) {
        if (cnt == 0) {
            return 4; // 如果没有剩余层数，返回4（骰子可以转动）
        }
        long ans = 0;

        // 遍历所有可能的上面数字
        for (int upp = 1; upp <= 6; upp++) {
            // 检查是否有冲突
            if (conflict[op[up]][upp]) continue; // 如果有冲突，跳过

            // 递归计算
            ans += f(upp, cnt - 1);
        }
        return ans; // 返回当前状态下的可能性
    }

    /**
     * 初始化对面数字的关系
     */
    public static void init() {
        op[1] = 4; // 1的对面是4
        op[4] = 1; // 4的对面是1
        op[2] = 5; // 2的对面是5
        op[5] = 2; // 5的对面是2
        op[3] = 6; // 3的对面是6
        op[6] = 3; // 6的对面是3
    }
}