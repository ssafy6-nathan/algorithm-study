package study.nathan_algo_study.week59;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 뱀
 * 링크 : https://www.acmicpc.net/problem/3190
 */

public class Baekjoon3190 {
    static int N, K, L;
    static int[][] board;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            board[r][c] = 1;
        }
        L = Integer.parseInt(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().charAt(0) == 'L'? -1 : 1;
            //왼쪽은 -1, 오른쪽은 1

            q.offer(new int[]{sec, dir});
        }

        System.out.println(simul(q));
    }

    public static int simul(Deque<int[]> q) {
        board[0][0] = -1;
        int[][] snakeDirHistory = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(snakeDirHistory[i], -1);
        }
        // 0 : 우, 1 : 하, 2 : 좌, 3 : 상

        //현재 좌표
        int cr = 0;
        int cc = 0;
        int currDir = 0;

        //꼬리좌표
        int tr = 0;
        int tc = 0;

        int currTime = 0;

        while(true) {
            currTime++;
            snakeDirHistory[cr][cc] = currDir;  //이전좌표에서 현재좌표로 이동한 방향 기억
            cr += dir[currDir][0];
            cc += dir[currDir][1];

            //벽이나 자기자신의 몸과 부딪히면 게임이 끝남
            if (cr < 0 || cr >= N || cc < 0 || cc >= N || board[cr][cc] == -1)
                break;

            if (!q.isEmpty() && q.peek()[0] == currTime) {
                int[] item = q.poll();
                int nextDir = item[1];
                currDir = nextDir == -1? (currDir + 3) % 4: (currDir + 1) % 4;
                //nextDir가 -1이면 반시계방향 1이면 시계방향으로 90도 회전
            }

            //이동한 곳에 사과가 없으면 꼬리를 줄임
            if (board[cr][cc] == 0) {
                board[tr][tc] = 0;
                int tempR = tr;
                int tempC = tc;
                tr += dir[snakeDirHistory[tempR][tempC]][0];
                tc += dir[snakeDirHistory[tempR][tempC]][1];
            }

            //이동한 곳에 뱀의 몸이 생김
            board[cr][cc] = -1;
        }

        return currTime;
    }
}

/*
0 0 0
0 0 0
0 0 0

0 0 0
x x 0


*/
