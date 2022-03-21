package study.nathan_algo_study.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 운동
 * 링크 : https://www.acmicpc.net/problem/1956
 */

public class Baekjoon1956 {
    static int V, E;
    static int[][] dist;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
             
            dist[from-1][to-1] = distance;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                if (k == i)
                    continue;
                for (int j = 0; j < V; j++) {
                    if (j == i || j == k)
                        continue;

                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int min = INF;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j || dist[i][j] == INF || dist[i][j] == INF)
                    continue;
                min = Math.min(dist[i][j] + dist[j][i], min);
            }
        }
        
        if (min == INF)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}

/*

*/
