package study.nathan_algo_study.week13;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 퇴사 2
 * 링크 : https://www.acmicpc.net/problem/15486
 */

public class Baekjoon15486 {
    static int[] dp;
    static int[] P;
    static int[] T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        P = new int[N + 1];
        T = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            T[i] = t;
            P[i] = p;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] > N)
                dp[i] = dp[i+1];
            else
                dp[i] = Math.max(dp[i+1], P[i] + dp[i + T[i]]);
        }

        System.out.println(dp[0]);
    }
}

/*




 */
