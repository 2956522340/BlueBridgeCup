package BlueBridgeCupThird;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 编写一函数lcm，求两个正整数的最小公倍数。
 * 
 */
public class Five_One_LCM {
	
	public static int lcm(int a, int b) {
		
		return (a * b) / gcd(a, b);
		
	}
	
	public static int gcd(int a, int b) {
		
		int m = a % b;
		
		while (m != 0) {
			
			a = b;
			
			b = m;
			
			m = a % b;
			
		}
		
		return b;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Integer a = sc.nextInt();
		
		Integer b = sc.nextInt();
		
		System.out.println(lcm(a, b));
		
	}

}
