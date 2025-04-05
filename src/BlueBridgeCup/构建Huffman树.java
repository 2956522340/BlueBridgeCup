package BlueBridgeCup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 构建Huffman树 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		sc.close();
		Collections.sort(list);
		int len = 0;
		int res = 0;
		while (list.size() != 1) {
			int temp = list.get(0) + list.get(1);
			list.remove(0);
			list.remove(0);
			list.add(temp);
			res += temp;
			Collections.sort(list);
		}
		System.out.println(res);
	}
}
