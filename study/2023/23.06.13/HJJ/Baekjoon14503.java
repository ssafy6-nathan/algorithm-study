package study.nathan_algo_study.week58;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 로봇청소기
 * 링크 : https://www.acmicpc.net/problem/14503
 */

public class Baekjoon14503 {
    static int N, M;
    static int[][] map;
    static int cnt;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        simulation(startR, startC, startD);

        System.out.println(cnt);

    }

    public static void simulation(int startR, int startC, int startD) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startR, startC, startD});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            //1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
            if (map[r][c] == 0) {
                map[r][c] = -1;
                cnt++;
            }

            //현재 칸의 주변 4칸 탐색
            boolean isAllClean = true;
            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] == 1 || map[dr][dc] == -1)
                    continue;

                isAllClean = false;
                break;
            }

            if (isAllClean) { //2. 청소되지 않은 빈 칸이 없는 경우
                int dd = (d + 2) % 4;   //후진
                int dr = r + dir[dd][0];
                int dc = c + dir[dd][1];

                if (dr >= 0 && dr < N && dc >= 0 && dc < M && map[dr][dc] != 1)
                    q.offer(new int[]{dr, dc, d});    // 바라보는 방향을 유지한 채로 한 칸 후진
                else
                    break;  //후진할 수 없으면 작동 종료

            } else {    //3. 청소되지 않은 빈 칸이 없는 경우
                int dd = (d + 3) % 4;   //반시계 방향으로 90도 회전
                int dr = r + dir[dd][0];
                int dc = c + dir[dd][1];

                if (dr >= 0 && dr < N && dc >= 0 && dc < M) {
                    if (map[dr][dc] == 0)   //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                        q.offer(new int[]{dr, dc, dd});
                    else    //청소되지 않은 빈 칸인 경우 현재 위치 그대로
                        q.offer(new int[]{r, c, dd});
                }
            }
        }


    }
}

/*

 */
