package study.nathan_algo_study.week18;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 베르트랑 공준
 * 링크 : https://www.acmicpc.net/problem/4948
 */

public class Baekjoon4948 {
    static boolean[] primes;
    static final int MAX = 250000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        primes = new boolean[MAX + 1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i*i <= MAX; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j <= MAX; j += i) {
                    primes[j] = false;
                }
            }
        }

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0)
            bw.write(getPrimeCnt(n) + "\n");

        bw.close();

    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int getPrimeCnt(int n) {
        int cnt = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (primes[i])
                cnt++;
        }
        return cnt;
    }
}

/*

 */
