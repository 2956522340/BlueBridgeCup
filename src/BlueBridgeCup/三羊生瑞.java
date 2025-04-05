package BlueBridgeCup;

/**
 * @author guh
 * @description 
 * 三羊生瑞
 * 观察下面的加法算式：
 * 		祥瑞生辉
 * 	+	三羊献瑞
 * ------------------
 *    三羊生瑞气
 * 其中，相同的汉字代表相同的数字，不同的汉子代表不同的数字。
 * 请你填写“三羊献瑞”所代表的4位数字（答案唯一）
 * 
 */
public class 三羊生瑞 {
	public static void main(String[] args) {
		int ans = 0;
		for (int a = 1; a < 10; a++) {
			// 这个位置代表的是“祥“，不能为0开头
			for (int b = 0; b < 10; b++) {
				if (b != a) {
					for (int c = 0; c < 10; c++) {
						if (c != a && c != b) {
							for (int d = 0; d < 10; d++) {
								if (d != a && d != b && d != c) {
									// 当前的位置代表的是“三”，这个四位数开头则不能为0
									for (int e = 1; e < 10; e++) {
										if (e != a && e != b && e != c && e != d) {
											for (int f = 0; f < 10; f++) {
												if (f != a && f != b && f != c && f != d && f != e) {
													for (int g = 0; g < 10; g++) {
														if (g != a && g != b && g != c && g != d && g != e && g != f) {
															for (int h = 0; h < 10; h++) {
																if (h != a && h != b && h != c && h != d && h != e && h != f && h != g) {
																	int shang = a * 1000 + b * 100 + c * 10 + d;
																	int xiang = e * 1000 + f * 100 + g * 10 + b;
																	int result = e * 10000 + f * 1000 + c * 100 + b * 10 + h;
																	if ((shang + xiang) == result) {
																		ans++;
																		System.out.println(a + "," + b + "," + c + "," + d);
																		System.out.println(e + "," + f + "," + g + "," + b);
																		System.out.println(e + "," + f + "," + c + "," + b + "," + h);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("结果=" + ans);
	}
}
