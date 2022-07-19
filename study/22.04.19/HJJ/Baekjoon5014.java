package study.nathan_algo_study.week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 스타트링크
 * 링크 : https://www.acmicpc.net/problem/5014
 */

public class Baekjoon5014 {
    static int F,S,G;
    static int[] button;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        button = new int[2];
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        button[0] = Integer.parseInt(st.nextToken());
        button[1] = -Integer.parseInt(st.nextToken());


        int result = bfs();
        if (result == -1)
            System.out.println("use the stairs");
        else
            System.out.println(result);

    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[F+1];

        q.add(new int[]{S, 0});
        v[S] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == G)
                return curr[1];

            for (int i = 0; i < button.length; i++) {
                int next = curr[0] + button[i];

                if (next < 1 || next > F || v[next])
                    continue;

                q.add(new int[]{next, curr[1]+1});
                v[next] = true;
            }
        }

        return -1;
    }
}

/*
1 10
2 1

1 3 5 7 9 8 10

22
3
5

21
16
19
22

10 2 10 3 2

*/
