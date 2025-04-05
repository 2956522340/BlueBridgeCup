package BlueBridgeCup;


/**
 * @author guh
 * @description 
 * 武林秘笈
 * 小明到X生洞探险，捡到一本有破损的武林秘笈（2000多页！当然是伪造的）。它注意到：书的第10页和第11页在同一张纸上，但第11页和第12页不在
 * 同一张纸上，小明只想练习该书的第81页到92页的武功，又不想带着整本书。请问他至少要撕下多少张纸带走？
 * 这是一个整数，请通过浏览器提交该数字，不要填写任何多余的内容
 * 
 * 1 2-3 4-5 6-7 8-9 10-11
 */
public class 武林秘笈 {
	public static void main(String[] args) {
		int page = 81;
		int n = 0;
		int k = 0;
		while(page <= 92) {
			int i = page % 10;
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
				n += 1;
			}
			page++;
			k = i;
		}
		if (k == 0 || k == 2 || k == 4 || k == 6 || k == 8)
			n++;
		System.out.print(n);
	}
}
