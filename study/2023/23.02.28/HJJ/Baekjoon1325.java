package study.nathan_algo_study.week48;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 효율적인 해킹
 * 링크 : https://www.acmicpc.net/problem/1325
 */

public class Baekjoon1325 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] nums;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            bfs(i);
            nums[i] = cnt;
            max = Math.max(cnt, max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (nums[i] == max)
                sb.append(i+" ");
        }

        System.out.println(sb);
    }

    public static void bfs(int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        boolean[] v = new boolean[N + 1];
        v[n] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (v[next])
                    continue;

                q.offer(next);
                v[next] = true;
                cnt++;
            }
        }

    }
}

/*
1 3 4
1 3 5
2 3


 */
