package study.nathan_algo_study.week16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 로또
 * 링크 : https://www.acmicpc.net/problem/6603
 */

public class Baekjoon6603 {
    static int K;
    static int[] S;
    static int[] p;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0)
                break;

            S = new int[K];
            for (int i = 0; i < K; i++)
                S[i] = Integer.parseInt(st.nextToken());

            p = new int[6];
            combi(0, 0, new boolean[K]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void combi(int cnt, int idx, boolean[] v) {
        if (cnt == 6) {
            for (int i = 0; i < p.length; i++)
                sb.append(p[i]+" ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i < K; i++) {
            if (v[i])
                continue;

            p[cnt] = S[i];
            v[i] = true;
            combi(cnt+1, i, v);
            v[i] = false;
        }
    }
}

/*

*/
