package study.nathan_algo_study.week21;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 줄 세우기
 * 링크 : https://www.acmicpc.net/problem/2252
 */

public class Baekjoon2252 {
    static ArrayList<Integer>[] graph;
    static int N, M;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            indegree[to]++;
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (Integer i : graph[curr]) {
                indegree[i]--;

                if (indegree[i] == 0)
                    q.add(i);
            }
        }

        for (Integer i : result)
            System.out.print(i+" ");
        System.out.println();
    }
}

/*

*/
