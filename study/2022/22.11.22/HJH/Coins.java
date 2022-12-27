import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            solution();
        }

    }

    static void solution() {
        dp = new int[10010];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[m]);
    }
}
