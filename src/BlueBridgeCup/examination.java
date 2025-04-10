package BlueBridgeCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class examination {
	static int n, m, k;
	static int[][]data;
	static int MOD = 1000000007;
	static long[][][][] cache;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		sc.close();
		Collections.sort(list);
		
		int len = 0;
		int res = 0;
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
	
}
