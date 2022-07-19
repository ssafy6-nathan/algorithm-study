package study.nathan_algo_study.week11;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 숨바꼭질 3
 * 링크 : https://www.acmicpc.net/problem/13549
 */

public class Baekjoon13549 {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(zeroOneBFS(n,k));
    }

    public static int zeroOneBFS(int n, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] v = new boolean[MAX];
        dq.addFirst(new int[]{n, 0});

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();
            int pos = curr[0];
            int time = curr[1];

            if (pos == k)
                return time;

            int warp = pos * 2;
            int next = pos + 1;
            int prev = pos - 1;

            if (warp < MAX && !v[warp]) {
                v[warp] = true;
                dq.addFirst(new int[]{warp, time});
            }

            if (prev >= 0 && !v[prev]) {
                v[prev] = true;
                dq.addLast(new int[]{prev, time + 1});
            }

            if (next < MAX && !v[next]) {
                v[next] = true;
                dq.addLast(new int[]{next, time + 1});
            }
        }

        return -1;
    }
}

/*
5 17

5 0

10 4 6

10 0







 */
