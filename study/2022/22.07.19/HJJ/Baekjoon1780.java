package study.nathan_algo_study.week21;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 종이의 개수
 * 링크 : https://www.acmicpc.net/problem/1780
 */

public class Baekjoon1780 {
    static int N;
    static int[][] paper;
    static int[] paperCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        paperCnt = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0,0,N);

        for (int i = 0; i < 3; i++)
            System.out.println(paperCnt[i]);
    }

    public static void check(int r, int c, int n) {
        int curr = paper[r][c];
        if (isEqual(r, c, n)) {
            paperCnt[curr + 1]++;

            return;
        }

        int nextN = n / 3;
        check(r, c, nextN);
        check(r, c + nextN, nextN);
        check(r, c + 2 * nextN, nextN);

        check(r + nextN, c, nextN);
        check(r + nextN, c + nextN, nextN);
        check(r + nextN, c + 2 * nextN, nextN);

        check(r + 2 * nextN, c, nextN);
        check(r + 2 * nextN, c + nextN, nextN);
        check(r + 2 * nextN, c + 2 * nextN, nextN);
    }

    public static boolean isEqual(int r, int c, int n) {
        int curr = paper[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[i][j] != curr)
                    return false;
            }
        }
        return true;
    }
}

/*

 */
