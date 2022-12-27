package study.nathan_algo_study.week13;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 떡 먹는 호랑이
 * 링크 : https://www.acmicpc.net/problem/2502
 */

public class Baekjoon2502 {
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        A = new int[31];
        B = new int[31];

        A[1] = 1;
        B[2] = 1;
        for (int i = 3; i < A.length; i++) {
            A[i] = A[i-2] + A[i-1];
            B[i] = B[i-2] + B[i-1];
        }

        int a = 1;
        int b;
        while (true) {
            int temp = K - (A[D] * a);
            if (temp % B[D] == 0) {
                b = temp / B[D];
                break;
            }
            a++;
        }

        System.out.println(a);
        System.out.println(b);
    }
}

/*

a
b
a,b
a,2b
2a,3b
3a,5b
5a,8b
8a,13b
13a,21b

*/
