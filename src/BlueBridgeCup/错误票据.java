package BlueBridgeCup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * 标题：错误票据
 * 某涉密单位下发了某种票据，并要在年终全部收回。
 * 每张票据有唯一的ID号。全年所有票据的ID是连续的，但ID的开始数码是随机选定的。
 * 因为工作人员的疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号
 * 你的任务是通过编程，找出断号和重号的ID。
 * 假设断号不可能发生在最大和最小号。
 * 
 * 要求程序首先输入一个整数N(N<100)表示后面数据行数。
 * 接着读入N行数据
 * 每行数据长度不等，是用空格分开的若干个（不大于100个）正整数（不大于100000）
 * 每个整数代表一个ID号
 * 要求程序代码一个ID号
 * 要求程序输出1行，含两个整数mn，用空格分割
 * 其中，m表示断号ID、n表示重号ID
 * 
 * 例如：用户输入
 * 2
 * 5 6 8 11 9
 * 10 12 9
 *  则程序输出 7 9
 *  
 *  在例如：
 *  用户输入：
 *  6
 *  164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129 168 196
 *  172 189 127 107 112 192 103 131 133 169 158 128
 *  102 110 148 139 157 140 195 197
 *  185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134 162 190
 *  149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194 187 188
 *  113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198 111 119
 *  
 *  则程序输出：
 *  105 120
 *  
 *  资源约定：
 *  峰值内存消耗（含虚拟机） < 64M
 *  CPU消耗 < 2000ms

则程序输出：
 */
public class 错误票据 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			for (int j = 0; j < split.length; j++) {
				list.add(Integer.parseInt(split[j]));
			}
		}
		sc.close();
		Collections.sort(list);
		
		int a = 0;
		int b = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i + 1) - list.get(i) == 2) {
				a = list.get(i + 1) - 1;
			}
			if (list.get(i + 1) - list.get(i) == 0) {
				b = list.get(i + 1);
			}
		}
		System.out.println(a + " " + b);
	}
}
