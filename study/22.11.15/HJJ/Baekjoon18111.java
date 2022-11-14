package study.nathan_algo_study.week36;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 마인크래프트
 * 링크 : https://www.acmicpc.net/problem/18111
 */

public class Baekjoon18111 {
    static int N, M, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (int height = min; height <= max; height++) {
            int inven = B;
            int time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int posHeight = map[i][j];

                    if (posHeight == height) //탐색하는 높이가 현재 좌표의 높이랑 같으면 넘어감
                        continue;

                    if (posHeight < height) {    //탐색하는 높이가 현재 좌표의 높이보다 높으면 -> 블럭 쌓음
                        time += height - posHeight;
                        inven -= height - posHeight;
                    } else {    //탐색하는 높이가 현재 좌표의 높이보다 낮으면 -> 블럭 제거
                        time += (posHeight - height) * 2;
                        inven += posHeight - height;
                    }
                }
            }
            if (inven < 0)  //인벤토리가 음수이면 불가능한 높이
                continue;

            if (time <= minTime) {
                minTime = time;
                maxHeight = height;
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}

/*
250000 * 256

64000000


*/
