package BlueBridgeCupThird;

import java.util.Scanner;

public class test {
	public static int is_Palindrome(String str) {
		if (str.length() % 2 == 0) {
			String left = str.substring(0, str.length() / 2);
			String right = str.substring(str.length() / 2, str.length());
			right = new StringBuffer(right).reverse().toString();
			if (left.equals(right)) {
				return 1;
			}
		} else {
			String left = str.substring(0, str.length() / 2);
			String right = str.substring(str.length() / 2 + 1, str.length());
			right = new StringBuffer(right).reverse().toString();
			if (left.equals(right)) {
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int step = 1;
		Integer M = sc.nextInt();
		String N = sc.next();
		sc.close();
		while (true) {
			if (step == 31) {
				System.out.println("Impossibe!");
				return;
			}
			Long nz = Long.valueOf(N, M);
			String nf = new StringBuffer(N).reverse().toString();
			Long nn = Long.valueOf(nf, M);
			Long rs = nz + nn;
			String rss = Long.toString(rs, M);
			if (is_Palindrome(rss) == 1) {
				System.out.println("STEP=" + step);
				return;
			}
			step++;
			N = String.valueOf(rss);
		}
	}
}
