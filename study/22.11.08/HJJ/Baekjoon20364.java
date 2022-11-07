package study.nathan_algo_study.week35;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 부동산 다툼
 * 링크 : https://www.acmicpc.net/problem/20364
 */

public class Baekjoon20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[N+1];

        for (int t = 0; t < Q; t++) {
            int q = Integer.parseInt(br.readLine());

            boolean isFail = false;
            int save = 0;
            for (int i = q; i > 0; i >>= 1) {
                if (v[i]) {
                    isFail = true;
                    save = i;
                }

            }
            if (!isFail)
                v[q] = true;

            bw.write(save+"\n");
        }
        bw.close();
    }
}

/*

*/
