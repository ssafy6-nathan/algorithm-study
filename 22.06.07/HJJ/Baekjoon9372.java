package study.nathan_algo_study.week15;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 상근이의 여행
 * 링크 : https://www.acmicpc.net/problem/9372
 */

public class Baekjoon9372 {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] v;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N+1];
            v = new boolean[N+1];
            for (int i = 0; i <= N; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            cnt = 0;
            dfs(1);
            bw.write(cnt+"\n");
        }
        bw.close();

    }

    public static void dfs(int curr) {
        v[curr] = true;

        for (int next : graph[curr]) {
            if (v[next])
                continue;

            cnt++;
            dfs(next);
        }
    }
}

/*
1 2
2 3
1 3


*/
