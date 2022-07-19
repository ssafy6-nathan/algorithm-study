package study.nathan_algo_study.week17;

import java.io.*;

/**
 * 문제이름 : 골드바흐의 추측
 * 링크 : https://www.acmicpc.net/problem/9020
 */

public class Baekjoon9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] result = check(n);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.close();
    }

    public static int[] check(int n) {
        int n1 = 0;
        int n2 = n;
        int temp;
        for (int i = 2; i < n; i++) {
            temp = n - i;
            if (isPrime(i) && isPrime(temp)) {
                if (Math.abs(n1 - n2) > Math.abs(temp - i)) {
                    n1 = i;
                    n2 = n - i;
                }
            }
        }

        return new int[]{n1, n2};
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

/*

 */
