package BlueBridgeCup;

public class 全排列 {
	static int ans = 0;
	public static void main(String[] args) {
		int []arr = {1, 2, 3, 4};
		f(arr, 0);
		System.out.println(ans);
	}
	
	private static void f(int[] arr, int k) {
		if (k == arr.length -1) {
			print(arr);
			ans++;
		}
		
		for (int i = k; i < arr.length; i++) {
			int t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
			
			f(arr, k + 1);
			
			t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
		}
	}
	
	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
}
