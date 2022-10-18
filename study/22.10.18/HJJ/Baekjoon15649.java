package study.nathan_algo_study.week32;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : N과 M(1)
 * 링크 : https://www.acmicpc.net/problem/15649
 */

public class Baekjoon15649 {
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        perm(0, new int[M],new boolean[N+1]);

        System.out.println(sb.toString());
    }

    public static void perm(int cnt, int[] num, boolean[] v) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                sb.append(num[i] + " ");
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (v[i])
                continue;

            num[cnt] = i;
            v[i] = true;
            perm(cnt + 1, num, v);
            v[i] = false;
        }
    }
}

/*

 */
