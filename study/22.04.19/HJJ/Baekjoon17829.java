package study.nathan_algo_study.week8;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 222-풀링
 * 링크 : https://www.acmicpc.net/problem/17829
 */

public class Baekjoon17829 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        while (N != 1)
            polling(0,0, N);

        System.out.println(map[0][0]);
    }

    public static void polling(int r, int c, int n) {
        if (n == 2) {
            int[] temp = new int[4];
            temp[0] = map[r][c];
            temp[1] = map[r][c+1];
            temp[2] = map[r+1][c];
            temp[3] = map[r+1][c+1];

            Arrays.sort(temp);

            map[r/2][c/2] = temp[2];
            if (N == 2)
                N = 1;

            return;
        }

        for (int i = r; i < N; i+=2)
            for (int j = c; j < N; j+=2)
                polling(i,j,2);

        N /= 2;
    }
}

/*
9 9
17 21

17


*/
