package study.nathan_algo_study.week11;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 바이러스
 * 링크 : https://www.acmicpc.net/problem/2606
 */

public class Baekjoon2606 {
    static int N, M;
    static ArrayList<Integer>[] network;
    static boolean[] v;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        network = new ArrayList[N];
        for (int i = 0; i < N; i++)
            network[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            network[from].add(to);
            network[to].add(from);
        }

        v = new boolean[N];
        cnt = -1;
        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int curr) {
        v[curr] = true;
        cnt++;

        for (int next : network[curr]) {
            if (v[next])
                continue;

            dfs(next);
        }
    }
}

/*

*/
