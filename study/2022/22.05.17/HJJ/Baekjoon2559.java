package study.nathan_algo_study.week12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 수열
 * 링크 : https://www.acmicpc.net/problem/2559
 */

public class Baekjoon2559 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(sequence());
    }

    public static int sequence() {
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += arr[i];
        int maxSum = sum;
        int prev = 0;
        for (int i = K; i < N; i++) {
            sum -= arr[prev++];
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

/*

*/
