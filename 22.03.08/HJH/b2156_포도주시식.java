import java.io.IOException;
import java.util.Scanner;
//dp
public class b2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] grapes = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			grapes[i] = in.nextInt();
		}
		in.close();
		int[] dp = new int[N + 1];
		dp[1] = grapes[1];
		if (N >= 2) {
			dp[2] = grapes[1] + grapes[2];
		}
		for (int i = 3; i <= N; i++) {
			// 여기가 달라짐
			// dp[i] = Math.max(dp[i - 2], dp[i - 3] + grapes[i - 1]) + grapes[i];
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], dp[i - 3] + grapes[i - 1] + grapes[i]));
		}
		System.out.println(dp[N]);
	}
}
