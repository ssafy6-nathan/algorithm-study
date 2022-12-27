package study.nathan_algo_study.week23;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 정수 삼각형
 * 링크 : https://www.acmicpc.net/problem/1932
 */

public class Baekjoon1932 {
    static int[][] triangle;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        triangle = new int[N + 1][N];
        dp = new int[N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++)
                triangle[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0)
                    dp[j] = dp[j] + triangle[i][j];
                else
                    dp[j] = Math.max(dp[j - 1] + triangle[i][j], dp[j] + triangle[i][j]);

            }
        }

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}

/*
i,j
i+1,j i+1,j+1

*/
