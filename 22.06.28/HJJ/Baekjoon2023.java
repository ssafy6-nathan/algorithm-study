package study.nathan_algo_study.week18;

import java.io.*;

/**
 * 문제이름 : 신기한 소수
 * 링크 : https://www.acmicpc.net/problem/2023
 */

public class Baekjoon2023 {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        searchAmazingPrime(0, "");
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void searchAmazingPrime(int cnt, String num) {
        if (cnt == N) {
            sb.append(num + "\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!isPrime(Integer.valueOf(num + i)))
                continue;

            searchAmazingPrime(cnt + 1, num + i);
        }
    }

}

/*

 */
