package study.nathan_algo_study.week37;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 실은데요
 * 링크 : https://www.acmicpc.net/problem/25916
 */

public class Baekjoon25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] holes = new int[N];

        for (int i = 0; i < N; i++)
            holes[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int curr = 0;
        int max = 0;

        while (right < N) {
            if (left == right || curr <= M) {
                curr += holes[right++];
            } else if (curr > M)
                curr -= holes[left++];

            if (curr <= M)
                max = Math.max(curr, max);
        }

        System.out.println(max);
    }
}

/*
int curr = 0;

if left와 right가 같으면
    right 이동
else if curr가 M보다 작거나 같으면
    right 이동
else if curr가 M보다 크면
    left 이동



*/
