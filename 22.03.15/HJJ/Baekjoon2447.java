package study.nathan_algo_study.week3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 별 찍기 - 10
 * 링크 : https://www.acmicpc.net/problem/2447
 */

public class Baekjoon2447 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = ' ';

        divideAndConquer(0,0, n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                bw.write(map[i][j]);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void divideAndConquer(int r, int c, int n) {
        if (n == 3) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (i == r + 1 && j == c + 1)   //중앙 부분만 비워둠
                        continue;
                    map[i][j] = '*';
                }
            }
            return;
        }

        int nextN = n / 3;
        divideAndConquer(r, c, nextN);
        divideAndConquer(r, c + nextN, nextN);
        divideAndConquer(r, c + nextN * 2, nextN);

        divideAndConquer(r + nextN, c, nextN);
        divideAndConquer(r + nextN, c + nextN * 2, nextN);

        divideAndConquer(r + nextN*2, c, nextN);
        divideAndConquer(r + nextN*2, c + nextN, nextN);
        divideAndConquer(r + nextN*2, c + nextN*2, nextN);
    }
}

/*

 */
