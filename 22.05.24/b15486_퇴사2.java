import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15486_퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n + 2];
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);

            if (i + t[i] <= n + 1)
                dp[i + t[i]] = Math.max(max + p[i], dp[i + t[i]]);

        }
        System.out.println(max);
        br.close();
    }

//    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    private static int N, max;
//    private static int[] T, P;
//    private static int[] dp;
//
//    public static void main(String[] args) throws IOException {
//        N = Integer.parseInt(in.readLine());
//        T = new int[N + 2];
//        P = new int[N + 2];
//        dp = new int[N + 2];
//        for (int i = 1; i <= N; i++) {
//            StringTokenizer st = new StringTokenizer(in.readLine());
//            T[i] = Integer.parseInt(st.nextToken());
//            P[i] = Integer.parseInt(st.nextToken());
//        }
//
//        bottomUp();
//
//        System.out.println(max);
//    }
//
//    private static void bottomUp() {
//        for (int i = 1; i <= N + 1; i++) {
//            if (max < dp[i]) {
//                max = dp[i];
//            }
//
//            int day = i + T[i];
//            if (day <= N + 1) {
//                dp[day] = Math.max(dp[day], max + P[i]);
//            }
//        }
//    }

}
