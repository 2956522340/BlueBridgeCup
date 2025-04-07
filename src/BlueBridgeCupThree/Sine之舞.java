package BlueBridgeCupThree;

import java.math.BigDecimal;
import java.util.Scanner;

public class Sine之舞 {
	private static String str[];
	public static void main(String[] args) {
		/**
		 * ((sin(1) + 3) sin(1 - sin(2)) + 2) sin(1 - sin(2 + sin(3))) + 1
		 * (sin(1-sin(2+sin(3))))sin(1-sin(2))
		 * n = 3
		 * i = 1 -> sin(1) + 3
		 * i = 2 -> sin(1 - sin(2) + 2)
		 * i = 3 -> sin(1 - sin(2 + sin(3))) + 1
		 * 
		 * 
		 * (i - 1) -(1^i + 1)sin(1) + n
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		str = new String[n + 1];
		sc.close();
		SN(n);
	}
	
	public static void SN(int n) {
		for (int i = 1; i <= n; i++) {
			str[i] = AN(i - 1, i);
		}
		String temp = new String();
		for (int i = n, j = 1; i > 0 || j <= n; i--, j++) {
			if (j == n) {
				temp = String.format(temp + str[j] + "+" + i);
				break;
			}
			temp = String.format("(" + temp + str[j] + "+" + i + ")");
		}
		System.out.println(temp);
	}
	
	public static String AN(int n, int j) {
		if(j == 1) {
			return String.format("%ssin(%d)", (BigDecimal.valueOf(-1).pow(j + 1).compareTo(BigDecimal.ZERO)) < 0 ? "-" : "", j);
		} else if (j == 2){
			return String.format("sin(%d%ssin(%d))", j - 1, (BigDecimal.valueOf(-1).pow(j + 1).compareTo(BigDecimal.ZERO)) < 0 ? "-" : "+", j);
		} else {
			String temp = String.format("sin(%d%ssin(%d))",j - 1, (BigDecimal.valueOf(-1).pow(j + 1).compareTo(BigDecimal.ZERO)) < 0 ? "-" : "+", j);
			while (j > 2) {
				--j;
				temp = String.format("sin(%d%s%s)", j - 1,(BigDecimal.valueOf(-1).pow(j + 1).compareTo(BigDecimal.ZERO)) < 0 ? "-" : "+", temp);
			}
			return temp;
		}
	}
}
