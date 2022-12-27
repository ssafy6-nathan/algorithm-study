package study.nathan_algo_study.week42;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 가장 큰 정사각형
 * 링크 : https://www.acmicpc.net/problem/1915
 */

public class Baekjoon1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
                if (i == 0 || j == 0)
                    dp[i+1][j+1] = arr[i][j];
            }
        }

        int max = arr[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i-1][j-1] == 0)
                    continue;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max*max);
    }
}

/*

 */
