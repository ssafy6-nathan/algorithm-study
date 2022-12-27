package study.nathan_algo_study.week27;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 사탕 게임
 * 링크 : https://www.acmicpc.net/problem/3085
 */

public class Baekjoon3085 {
    static int N;
    static char[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        max = 0;

        solution();

        System.out.println(max);
    }

    public static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] != map[i][j + 1]) {
                    char temp1 = map[i][j];
                    char temp2 = map[i][j + 1];

                    map[i][j] = temp2;
                    map[i][j + 1] = temp1;

                    max = Math.max(findMaxCandy(), max);

                    map[i][j] = temp1;
                    map[i][j + 1] = temp2;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] != map[j+1][i]) {
                    char temp1 = map[j][i];
                    char temp2 = map[j+1][i];

                    map[j][i] = temp2;
                    map[j+1][i] = temp1;

                    max = Math.max(findMaxCandy(), max);

                    map[j][i] = temp1;
                    map[j+1][i] = temp2;
                }
            }
        }

    }

    public static int findMaxCandy() {
        int maxCnt = 0;
        int cnt;
        char currC;
        for (int i = 0; i < N; i++) {
            currC = map[i][0];
            cnt = 1;
            for (int j = 1; j < N; j++) {
                if (currC == map[i][j])
                    cnt++;
                else {
                    maxCnt = Math.max(cnt, maxCnt);
                    currC = map[i][j];
                    cnt = 1;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        for (int i = 0; i < N; i++) {
            currC = map[0][i];
            cnt = 1;
            for (int j = 1; j < N; j++) {
                if (currC == map[j][i])
                    cnt++;
                else {
                    maxCnt = Math.max(cnt, maxCnt);
                    currC = map[j][i];
                    cnt = 1;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        return maxCnt;
    }
}

/*

 */
