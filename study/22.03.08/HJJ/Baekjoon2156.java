package study.nathan_algo_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 포도주 시식
 * 링크 : https://www.acmicpc.net/problem/2156
 */

public class Baekjoon2156 {
    static int n;
    static int[] wines;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        wines = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++)
            wines[i] = Integer.parseInt(br.readLine());

        dp[1] = wines[1];
        int maxDrink = dp[1];
        if (n >= 2) {
            dp[2] = wines[1] + wines[2];
            maxDrink = dp[2];
        }

        if(n >= 3) {
            dp[3] = Math.max(dp[1], wines[2]) + wines[3];
            maxDrink = Math.max(dp[2], dp[3]);
        }

        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], wines[i - 1] + dp[i - 3]), wines[i - 1] + dp[i - 4]) + wines[i];
            maxDrink = Math.max(maxDrink, dp[i]);
        }

        br.close();
        System.out.println(maxDrink);
    }
}

/*

 */
