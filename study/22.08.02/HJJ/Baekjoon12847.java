package study.nathan_algo_study.week23;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 꿀 아르바이트
 * 링크 : https://www.acmicpc.net/problem/12847
 */

public class Baekjoon12847 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        long sum = 0;
        for (int i = 0; i < M; i++)
            sum += arr[i];

        max = sum;

        for (int i = M; i < N; i++) {
            sum -= arr[i - M];
            sum += arr[i];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}

/*

 */
