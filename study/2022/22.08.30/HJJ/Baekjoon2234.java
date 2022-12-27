package study.nathan_algo_study.week27;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 성곽
 * 링크 : https://www.acmicpc.net/problem/2234
 */

public class Baekjoon2234 {
    //왼쪽 1, 위쪽 2, 오른쪽 4, 아래쪽 8
    static int N, M;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};    //왼쪽 위쪽 오른쪽 아래쪽
    static int[][] map;
    static int[][] group;
    static boolean[][] v;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        group = new int[M][N];  //그룹번호를 한칸마다 저장함
        ArrayList<Integer> groupCnt = new ArrayList<>();    //각 그룹이 몇개의 방을 갖고 있는지 저장함

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[M][N];
        int maxRoomSize = 0;
        int roomCnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j])
                    continue;

                size = 0;
                dfs(i, j, roomCnt++);
                groupCnt.add(size);
                maxRoomSize = Math.max(size, maxRoomSize);
            }
        }

        int breakMaxRoomSize = findBreakMaxRoomSize(groupCnt);

        System.out.println(roomCnt);
        System.out.println(maxRoomSize);
        System.out.println(breakMaxRoomSize);
    }

    public static void dfs(int r, int c, int number) {
        v[r][c] = true;
        group[r][c] = number;
        size++;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= M || dc < 0 || dc >= N || v[dr][dc] || (map[r][c] & (1 << i)) > 0)
                continue;

            dfs(dr, dc, number);
        }
    }

    public static int findBreakMaxRoomSize(ArrayList<Integer> groupCnt) {
        v = new boolean[M][N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                v[i][j] = true;
                for (int k = 0; k < dir.length; k++) {
                    int dr = i + dir[k][0];
                    int dc = j + dir[k][1];

                    if (dr < 0 || dr >= M || dc < 0 || dc >= N || v[dr][dc] || group[i][j] == group[dr][dc])
                        continue;

                    max = Math.max(groupCnt.get(group[i][j]) + groupCnt.get(group[dr][dc]), max);
                }
            }
        }

        return max;
    }
}

/*
8 4 2 1

1 1 0 1


 */
