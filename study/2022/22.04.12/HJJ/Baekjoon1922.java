package study.nathan_algo_study.week7;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 네트워크 연결
 * 링크 : https://www.acmicpc.net/problem/1922
 */

public class Baekjoon1922 {
    static ArrayList<Edge>[] graph;
    static int N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        parent = new int[N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            parent[i] = i;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(from, to, cost);
            graph[from].add(edge);
            graph[to].add(new Edge(to, from, cost));

            pq.add(edge);
        }

        int kruskalResult = 0;
        for (int i = 0; i < M; i++) {
            Edge currEdge = pq.poll();
            int from = currEdge.from;
            int to = currEdge.to;
            int a = find(from);
            int b = find(to);
            if (a == b)
                continue;

            union(from, to);
            kruskalResult += currEdge.cost;;
        }

//        System.out.println(prim());
        System.out.println(kruskalResult);
    }

    public static int prim() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        boolean[] v = new boolean[N];
        int currEdge = 0;
        int totalCost = 0;

        while (currEdge != -1) {
            v[currEdge] = true;

            for (Edge next : graph[currEdge] ) {
                if (!v[next.to])
                    q.add(next);
            }

            currEdge = -1;
            while (!q.isEmpty()) {
                Edge edge = q.poll();
                if (!v[edge.to]) {
                    totalCost += edge.cost;
                    currEdge = edge.to;
                    break;
                }
            }
        }

        return totalCost;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

/*

*/
