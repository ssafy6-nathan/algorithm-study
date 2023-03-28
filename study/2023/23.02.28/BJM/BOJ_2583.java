package week48;

import java.io.*;
import java.util.*;

/**
 * 백준 2583번
 * 영역 구하기 (https://www.acmicpc.net/problem/2583)
 * 분류 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 너비 우선 탐색
 **/
public class BOJ_2583 {
    static int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] map;
    static boolean[][] visit;
    static int count; // 영역개수 카운팅
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 2차원 배열에 사각형 채우기
        map = new int[M][N];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            // 왼쪽 아래 꼭짓점
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            // 오른쪽 위 꼭짓점
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            // 사각형 채우기
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 2. 영역 탐색
        List<Integer> answer = new ArrayList<>(); // 영역 당 크기 정보 저장
        visit = new boolean[M][N];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 이미 방문했거나 사각형이 있으면 건너뜀
                if(visit[i][j] || map[i][j] == 1) continue;
                count = 0;
                dfs(i, j);
                answer.add(count);
            }
        }

        // 3. 영역 개수와 넓이 출력
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for (int i = 0; i < answer.size(); i++)
            bw.write(answer.get(i) + " ");
        bw.close();
    }

    private static void dfs(int r, int c) {
        visit[r][c] = true;
        count++;

        for (int i = 0; i < direct.length; i++) {
            int R = r + direct[i][0];
            int C = c + direct[i][1];

            if (R < 0 || R >= M || C < 0 || C >= N || map[R][C] == 1 || visit[R][C])
                continue;

            dfs(R, C);
        }
    }
}
