package study.nathan_algo_study.week64;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 구름 찾기 깃발
 * 링크 : https://level.goorm.io/exam/195689/%EA%B5%AC%EB%A6%84-%EC%B0%BE%EA%B8%B0-%EA%B9%83%EB%B0%9C/quiz/1
 */

public class Goorm195688 {
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int[][] board;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    continue;

                if (findGoormCnt(i, j) == K)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static int findGoormCnt(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N)
                continue;

            if (board[dr][dc] == 1)
                cnt++;
        }

        return cnt;
    }
}

/*

 */
