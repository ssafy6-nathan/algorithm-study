package study.nathan_algo_study.week20;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 파티
 * 링크 : https://www.acmicpc.net/problem/1238
 */

public class Baekjoon1238 {
    static class Node implements Comparable<Node>{
        int nextNode;
        int time;
        public Node(int nextNode, int time) {
            this.nextNode = nextNode;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static final int INF = Integer.MAX_VALUE - 10000000;
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, time));
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int time = dijkstra(i, X);
            time += dijkstra(X, i);

            maxTime = Math.max(maxTime, time);
        }

        System.out.println(maxTime);
    }

    public static int dijkstra(int start, int x) {
        dist = new int[N+1];
        for (int i = 0; i <= N; i++)
            dist[i] = INF;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[N+1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.nextNode;
            if (v[curr])
                continue;

            v[curr] = true;
            for (Node next : graph[curr]) {
                if (dist[next.nextNode] > dist[curr] + next.time) {
                    dist[next.nextNode] = dist[curr] + next.time;
                    pq.add(new Node(next.nextNode, dist[next.nextNode]));
                }
            }
        }

        return dist[x];
    }
}

/*

*/
