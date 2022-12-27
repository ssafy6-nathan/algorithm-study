package study.nathan_algo_study.week25;

import java.io.*;

/**
 * 문제이름 : 쉬운 계단 수
 * 링크 : https://www.acmicpc.net/problem/10844
 */

public class Baekjoon10844 {
    static int N;
    static long[][] dp;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for (int j = 0; j < 10; j++)
            dp[1][j] = 1L;

        long result = 0L;

        for (int i = 1; i < 10; i++)
            result += chair(N, i);

        System.out.println(result % MOD);
    }

    public static long chair(int pos, int num) {
        if (pos == 1)   //첫번째 자리이면 탐색 종료
            return dp[pos][num];

        if (dp[pos][num] == 0) {
            if (num == 0)
                dp[pos][num] = chair(pos - 1, 1);
            else if (num == 9)
                dp[pos][num] = chair(pos - 1, 8);
            else
                dp[pos][num] = chair(pos - 1, num - 1) + chair(pos -1, num + 1);
        }

        return dp[pos][num] % MOD;
    }
}

/*
1 2 3 4 5 6 7 8 9

12 23 34 45 56 67 78 89
21 32 43 54 65 76 87 98
10

1


*/
