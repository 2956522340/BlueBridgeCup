package BlueBridgeCupThird;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author guh
 * @description 
 * T 给出两个整数集合A、B，求出他们的交集、并集以及B在A中的余集。
 * 
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 5
 * 2 4 6 8 10
 * 
 * 样例输出
 * 2 4 (交集)
 * 1 2 3 4 5 6 8 10 (并集)
 * 1 3 5  (A中有，但是B没有的)  A - 交集
 * 
 * retainAll 交集
 * remove 查集
 * addAll addAll 并集
 */
public class Set_Operation_Vip {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		TreeSet<Integer> setA = new TreeSet<Integer>();
		for (int i = 0; i < a; i++) {
			setA.add(sc.nextInt());
		}
		int b = sc.nextInt();
		TreeSet<Integer> setB = new TreeSet<Integer>();
		for (int i = 0; i < b; i++) {
			setB.add(sc.nextInt());
		}
		sc.close();
		// 交集
		TreeSet<Integer> inter = new TreeSet<Integer>(setA);
		inter.retainAll(setB);
		inter.forEach(x -> System.out.print(x + " "));
		if (!inter.isEmpty()) {
			System.out.println();
		}
		
		// 交集
		TreeSet<Integer> union = new TreeSet<Integer>(setA);
		union.addAll(setB);
		union.forEach(x -> System.out.print(x + " "));
		if (!union.isEmpty()) {
			System.out.println();
		}
		
		// 差集
		TreeSet<Integer> diff = new TreeSet<Integer>(setA);
		diff.removeAll(setB);
		diff.forEach(x -> System.out.print(x + " "));
		if (!diff.isEmpty()) {
			System.out.println();
		}
	}
	
//	public static void Print(TreeSet<Integer> sTreeSet) {
//		Iterator<Integer> it = sTreeSet.iterator();  
//		while (it.hasNext()) {
//			Integer in = it.next();  
//			System.out.print(in + " ");
//		} 
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		TreeSet<Integer> TreeSetA = new TreeSet<Integer>();
//		TreeSet<Integer> TreeSetB = new TreeSet<Integer>();
//		TreeSet<Integer> rs = new TreeSet<Integer>();
//		Integer a = sc.nextInt();
//		while (a > 0) {
//			TreeSetA.add(sc.nextInt());
//			a--;
//		}
//		Integer b = sc.nextInt();
//		while (b > 0) {
//			TreeSetB.add(sc.nextInt());
//			b--;
//		}
//		sc.close();
//		rs.clear();
//		rs.addAll(TreeSetA);
//		rs.retainAll(TreeSetB);
//		Print(rs);
//		if (!rs.isEmpty())
//			System.out.println();
//		rs.clear();
//		rs.addAll(TreeSetA);
//		rs.addAll(TreeSetB);
//		Print(rs);
//		if (!rs.isEmpty())
//			System.out.println();
//		rs.clear();
//		rs.addAll(TreeSetA);
//		rs.retainAll(TreeSetB);
//		TreeSetA.removeAll(rs);
//		Print(TreeSetA);
//		if (!rs.isEmpty())
//			System.out.println();
//	}
}