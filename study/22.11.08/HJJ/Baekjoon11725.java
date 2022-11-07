package study.nathan_algo_study.week35;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 트리의 무보 찾기
 * 링크 : https://www.acmicpc.net/problem/11725
 */

public class Baekjoon11725 {
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        parents = new int[n + 1];
        v = new boolean[n + 1];

        for (int i = 0; i < tree.length; i++)
            tree[i] = new ArrayList<>();

        int from, to;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        v[1] = true;
        dfs(1);

        for (int i = 2; i < parents.length; i++)
            bw.write(parents[i]+"\n");
        bw.close();
    }

    public static void dfs(int node) {
        int child;

        for (int i = 0; i < tree[node].size(); i++) {
            child = tree[node].get(i);
            if (v[child])
                continue;

            parents[child] = node;
            v[child] = true;
            dfs(child);
        }
    }
}

/*

 */
