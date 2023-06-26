package study.nathan_algo_study.week59;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 나무 탈출
 * 링크 : https://www.acmicpc.net/problem/15900
 */

public class Baekjoon15900 {
    static int N;
    static List<Integer>[] graph;
    static int moveCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        moveCnt = 0;
        bfs();
        if (moveCnt % 2 != 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        boolean[] v = new boolean[N + 1];
        q.offer(new int[]{1, 0});
        v[1] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();

            int currNode = item[0];
            int currCnt = item[1];

            boolean isLeafNode = true;
            for (int nextNode : graph[currNode]) {
                if (v[nextNode])
                    continue;

                isLeafNode = false;

                q.offer(new int[]{nextNode, currCnt + 1});
                v[nextNode] = true;
            }

            if (isLeafNode)
                moveCnt += currCnt;
        }

    }
}

/*
루트노드에서 각 리프노드까지 도달하는데 걸리는 이동횟수의 합이
짝수이면 선공이 지고 홀수이면 선공이 이김

 1
 2
3  4
*/
