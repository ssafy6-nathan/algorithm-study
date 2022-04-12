package study.nathan_algo_study.week7;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 동전0
 * 링크 : https://www.acmicpc.net/problem/11047
 */

public class Baekjoon11047 {
    static int[] coins;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        System.out.println(coinCount());
    }

    public static int coinCount() {
        int temp = K;
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (temp == 0)
                break;
            cnt += temp / coins[i];
            temp %= coins[i];
        }

        return cnt;
    }
}

/*

*/
