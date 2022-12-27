package study.nathan_algo_study.week32;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : N과 M (4)
 * 링크 : https://www.acmicpc.net/problem/15652
 */

public class Baekjoon15652 {
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        perm(0, 1, new int[M]);

        System.out.println(sb.toString());
    }

    public static void perm(int cnt, int startNum, int[] num) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                sb.append(num[i] + " ");
            sb.append("\n");

            return;
        }

        for (int i = startNum; i <= N; i++) {
            num[cnt] = i;

            perm(cnt + 1, i, num);
        }
    }
}

/*

 */
