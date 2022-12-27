package study.nathan_algo_study.week22;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최소비용 구하기2
 * 링크 : https://www.acmicpc.net/problem/11779
 */

public class Baekjoon11779 {
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        String path;
        int cnt;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public Node(int to, int cost, String path, int cnt) {
            this.to = to;
            this.cost =cost;
            this.path = path;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static String[] paths;
    static int[] cityCnt;
    static int first, last;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        paths = new String[N+1];
        graph = new ArrayList[N+1];
        cityCnt = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            paths[i] = "";
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());

        dijkstra(first);

        bw.write(dist[last]+"\n");
        bw.write(cityCnt[last]+"\n");
        bw.write(paths[last]+"\n");
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[N+1];
        pq.add(new Node(start, 0, String.valueOf(start), 1));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.to;
            if (v[curr])
                continue;

            v[curr] = true;
            for (Node next : graph[curr]) {
                if (dist[next.to] >= dist[curr] + next.cost) {
                    dist[next.to] = dist[curr] + next.cost;
                    paths[next.to] = node.path+" "+next.to;
                    cityCnt[next.to] = node.cnt + 1;
                    pq.add(new Node(next.to, dist[next.to], paths[next.to], cityCnt[next.to]));
                }
            }
        }
    }
}

/*

*/
