package study.nathan_algo_study.week42;

import java.io.*;

/**
 * 문제이름 : 피보나치는 지겨웡~
 * 링크 : https://www.acmicpc.net/problem/17175
 */

public class Baekjoon17175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if (n < 2)
            System.out.println(1);
        else {
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++)
                dp[i] = (dp[i-2] + dp[i-1] + 1) % 1000000007;

            System.out.println(dp[n]);
        }
    }
}

/*
2
0 1

3
2 1
0 1

4
3 2
2 1
0 1
0 1


5
4 3


*/
