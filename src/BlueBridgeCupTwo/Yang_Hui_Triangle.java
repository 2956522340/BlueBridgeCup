package BlueBridgeCupTwo;

import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 *
 */

public class Yang_Hui_Triangle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		sc.close();
		
		int b[][] = new int[a.intValue()][a.intValue()];
		
		for (int i = 0; i < a.intValue(); i++) {
			
			for (int j = 0; j <= i; j++) {
				
				if (i == j || j == 0) {
					
					b[i][j] = 1;
					
				} else {
					
					b[i][j] = b[i-1][j] + b[i-1][j-1];
					
				}

				
			}
			
		}
		
		for (int i = 0; i < a.intValue(); i++) {
			
			for (int j = 0; j <= i; j++) {
				
				System.out.print(b[i][j] + " ");
				
			}
			
			System.out.println();
		
		}
		
		
	}

}














