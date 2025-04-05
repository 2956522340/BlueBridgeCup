package BlueBridgeCup;

/**
 * @author guh
 * @description 
 * 切面条
 * 一根高筋拉面，中间切一刀，可以得到2根面条。
 * 如果先对折1次，中间切一刀，可以得到3根面条
 * 如果连续对折2次，中间切一刀，可以得到5根面条
 * 3 -> 3 + 5
 * 那么连续对折10次。中间切一刀，会得到多少呢？
 * 
 * 1
 */
public class 切面条 {
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 10) + 1);
	}
}
