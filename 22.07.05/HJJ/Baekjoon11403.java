package study.nathan_algo_study.week19;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 경로 찾기
 * 링크 : https://www.acmicpc.net/problem/11403
 */

public class Baekjoon11403 {
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i)
                    continue;
                for (int j = 0; j < N; j++) {
                    graph[i][j] = (graph[i][k] + graph[k][j] > 1)? 1 : graph[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(graph[i][j]+" ");
            System.out.println();
        }

    }
}

/*

*/
