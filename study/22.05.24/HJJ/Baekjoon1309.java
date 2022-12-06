package study.nathan_algo_study.week13;

import java.io.*;

/**
 * 문제이름 : 동물원
 * 링크 : https://www.acmicpc.net/problem/1309
 */

public class Baekjoon1309 {
    static int N;
    static int[][] dp;
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        long result = (dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % MOD;
        System.out.println(result);
    }
}

/*
dp[N][0] = dp[N-1][0] + dp[N-1][1] + dp[N-1][2]
dp[N][1] = dp[N-1][0] + dp[N-1][2]
dp[N][2] = dp[N-1][0] + dp[N-1][1]


*/
