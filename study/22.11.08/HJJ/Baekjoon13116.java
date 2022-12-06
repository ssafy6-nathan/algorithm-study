package study.nathan_algo_study.week35;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 30번
 * 링크 : https://www.acmicpc.net/problem/13116
 */

public class Baekjoon13116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[] v;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v = new boolean[1024];

            for (int i = a; i > 0; i /= 2)
                v[i] = true;

            for (int i = b; i > 0; i /= 2) {
                if (v[i]) {
                    bw.write(i+"0\n");
                    break;
                }
            }
        }
        bw.close();
    }
}

/*
9 4 2 1
15 7 3 1

521
521

*/
