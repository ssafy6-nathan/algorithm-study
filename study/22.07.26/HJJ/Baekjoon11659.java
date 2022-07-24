package study.nathan_algo_study.week22;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 구간 합 구하기 4
 * 링크 : https://www.acmicpc.net/problem/11659
 */

public class Baekjoon11659 {
    static int N, M;
    static int[] arr;
    static int[] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(prefixSum(start,end)+"\n");
        }
        bw.close();
    }

    public static int prefixSum(int start, int end) {
        if (start == 1) {
            return prefixSum[end];
        } else {
            return prefixSum[end] - prefixSum[start-1];
        }
    }
}

/*
5 4 3 2 1
5 9 12 14 15


*/
