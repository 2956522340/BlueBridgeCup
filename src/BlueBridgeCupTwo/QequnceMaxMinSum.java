package BlueBridgeCupTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 */
public class QequnceMaxMinSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> dict = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dict.add(sc.nextInt());
		}
		sc.close();
		System.out.println(Collections.max(dict));
		System.out.println(Collections.min(dict));
		int ans = 0;
		for (int i : dict) {
			ans += i;
		}
		System.out.println(ans);
	}
}
