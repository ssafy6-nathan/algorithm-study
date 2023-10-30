package study.nathan_algo_study.week66;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : GameJam
 * 링크 : https://level.goorm.io/exam/195692/gamejam/quiz/1
 */

public class Goorm195692 {
    static int N;
    static boolean[][] board;
    static int[][][] role;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 하 상 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()) - 1;
        int c1 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken()) - 1;
        int c2 = Integer.parseInt(st.nextToken()) - 1;

        role = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String token = st.nextToken();
                role[i][j][0] = Integer.parseInt(token.substring(0, token.length() - 1));
                role[i][j][1] = parsingDir(token.substring(token.length() - 1));
            }
        }

        int goormCnt = play(r1, c1);
        int playerCtn = play(r2, c2);
        if (goormCnt > playerCtn)
            System.out.println("goorm " + goormCnt);
        else
            System.out.println("player " + playerCtn);
    }

    private static int parsingDir(String str) {
        int d = -1;
        switch (str) {
            case "U":
                d = 0;
                break;
            case "D":
                d = 1;
                break;
            case "L":
                d = 2;
                break;
            case "R":
                d = 3;
        }

        return d;
    }

    public static int play(int startR, int startC) {
        board = new boolean[N][N];

        int r = startR;
        int c = startC;
        int cnt = 1;
        do {
            board[r][c] = true;
            int move = role[r][c][0];
            int d = role[r][c][1];

            for (int i = 0; i < move; i++) {
                board[r][c] = true;
                int dr = r + dir[d][0];
                int dc = c + dir[d][1];
                r = dr >= 0 ? dr % N : N + (dr % N);
                c = dc >= 0 ? dc % N : N + (dc % N);

                if (board[r][c]) {
                    break;
                }

                cnt++;
            }
        } while (!board[r][c]);

        return cnt;
    }

}

/*
0 1 2 3 4
0 0 0 0 0
0 0 0 0 0

1 - 7 = -6 % 5 = -1
3 - 12 = -9 % 5 = -4
1?
*/
