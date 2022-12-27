package study.nathan_algo_study.week28;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 링크와 스타트
 * 링크 : https://www.acmicpc.net/problem/15661
 */

public class Baekjoon15661 {
    static int N;
    static int[][] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        values = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                values[i][j] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << N) / 2; i++) {
            int diff = valueDiff(i);
            min = Math.min(diff, min);

            if (min == 0)
                break;
        }

        System.out.println(min);
    }

    public static int valueDiff(int team) {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((team & (1 << i)) > 0 && (team & (1 << j)) > 0) {
                    start += values[i][j];
                    start += values[j][i];
                } else if ((team & (1 << i)) == 0 && (team & (1 << j)) == 0) {
                    link += values[i][j];
                    link += values[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }
}

/*
000
001
010
011
100
101
110
111

0000
0001
0010
0011
0100
0101
0110
0111

1000
1001
1010
1011
1100
1101
1110
1111



*/
