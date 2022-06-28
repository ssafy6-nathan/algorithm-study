package w18_220628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2981_검문 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gcdNum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < N; i++) {
			// 음수 안 나오게 절댓값 붙여줌
			gcdNum = gcd(gcdNum, Math.abs(arr[i] - arr[i - 1]));
		}
		// 최대공약수의 약수
		for (int i = 2; i <= gcdNum; i++) {
			if (gcdNum % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	private static int gcd(int a, int b) {
		return (a % b == 0 ? b : gcd(b, a % b));
	}
}
