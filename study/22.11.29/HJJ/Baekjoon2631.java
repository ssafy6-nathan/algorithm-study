package study.nathan_algo_study.week38;

import java.io.*;

/**
 * 문제이름 : 줄세우기
 * 링크 : https://www.acmicpc.net/problem/2631
 */

public class Baekjoon2631 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        dp[0] = 1;
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(N - result);
    }
}

/*
3 7 5 2 6 1 4
O X O X O X X

1 0 0 0 0 0 0
1 2 0 0 0 0 0
1 2 2 0 0 0 0
1 2 2 1 0 0 0
1 2 2 1 3 0 0
1 2 2 1 3 1 0
1 2 2 1 3 1 2

가장 긴 오름차순의 길이만큼 빼기


*/
