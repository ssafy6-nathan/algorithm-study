package study.nathan_algo_study.week58;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제이름 : 촌수계산
 * 링크 : https://www.acmicpc.net/problem/2644
 */

public class Baekjoon2644 {
    static int N, M;
    static int target1, target2;
    static List<Integer>[] graph;
    static boolean isSuccess;
    static int minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            graph[child].add(parent);
            graph[parent].add(child);
        }

        isSuccess = false;
        boolean[] v = new boolean[N + 1];
        v[target1] = true;
        minCnt = Integer.MAX_VALUE;
        dfs(target1, v, 0);

        if (isSuccess)
            System.out.println(minCnt);
        else
            System.out.println(-1);
    }

    public static void dfs(int curr, boolean[] v, int cnt) {
        if (curr == target2) {
            isSuccess = true;
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for (int next : graph[curr]) {
            if (v[next])
                continue;

            v[next] = true;
            dfs(next, v, cnt + 1);
            v[next] = false;
        }
    }
}

/*

2 3
1

7 8 9
2

5 6
4
*/
