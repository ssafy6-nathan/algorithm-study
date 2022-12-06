package study.nathan_algo_study.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 친구비
 * 링크 : https://www.acmicpc.net/problem/16562
 */

public class Baekjoon16562 {
    static int N, M, K;
    static int[] cost;
    static ArrayList<Integer>[] graph;
    static boolean[] v;
    static int minMoney;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cost = new int[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph[from].add(to);
            graph[to].add(from);
        }

        v = new boolean[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                minMoney = 10001;
                dfs(i);
                result += minMoney;
            }
        }

        if (K >= result)
            System.out.println(result);
        else
            System.out.println("Oh no");

    }

    public static void dfs(int curr) {
        v[curr] = true;
        minMoney = Math.min(cost[curr], minMoney);

        for (int next : graph[curr]) {
            if (v[next])
                continue;

            dfs(next);
        }
    }
}

/*

*/
