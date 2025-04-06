package BlueBridgeCupThree;

import java.util.Scanner;

/**
 * @author guh
 * @description  
 * T FJ在沙盘上写了这样一些字符串：
 * 	 A1 = “A”
 * 	 A2 = “ABA”
 *	 A3 = “ABA C ABA”
 * 	 A4 = “ABA C ABA D ABA C ABA”
 * 	 A5 = “ABA C ABA D ABA C ABA E ABA C ABA D ABA C ABA”
 * 	 … …
 * 	 你能找出其中的规律并写所有的数列AN吗？
 * 
 * 
 * 
 * 输入格式
 * 仅有一个数：N ≤ 26。
 * 输出格式
 * 请输出相应的字符串AN，以一个换行符结束。
 * 输出中不得含有多余的空格或换行、回车符。
 * 
 * 
 * 
 * 样例输入
 * 3
 * 样例输出
 * ABACABA
 */
public class FJ_String_Vip {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		sc.close();
		
		String[] str = {"A","B","C","D","E","F","G","H","I","J",
				"K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String zj = new String("");  // 结果AN...
		
		String rs = new String("");  // 结果AN...
		for (int i = 0; i < a; i++) {
						
			rs = zj + str[i] + zj;
			
			zj = rs;
			
			
		}
		
		
		System.out.println(rs);
		
		
		
	}
	
	
}



















