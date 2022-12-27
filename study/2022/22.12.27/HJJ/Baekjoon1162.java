package study.nathan_algo_study.week42;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 도로포장
 * 링크 : https://www.acmicpc.net/problem/1162
 */

public class Baekjoon1162 {
    static int N, M, K;
    static ArrayList<Node>[] graph;
    static long[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        dist = new long[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        dijkstra(1);

        long result = Long.MAX_VALUE;
        //
        for (int i = 1; i <= K; i++) {
            result = Math.min(result, dist[N][i]);
        }

        System.out.println(result);
    }

    public static void dijkstra(int node) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));
        pq.offer(new Node(node, 0));
        dist[node][0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            //현재 노드의 가중치가 dist에 저장된 가중치보다 크면 무시함
            if (curr.weight > dist[curr.to][curr.count])
                continue;

            for (Node next : graph[curr.to]) {
                //도로를 포장하지 않은 경우 (count)
                if (dist[next.to][curr.count] > curr.weight + next.weight) {
                    dist[next.to][curr.count] = curr.weight + next.weight;
                    pq.offer(new Node(next.to, dist[next.to][curr.count], curr.count));
                }
                //도로를 포장했을 경우 (count + 1)
                if (curr.count < K && dist[next.to][curr.count + 1] > curr.weight) {
                    dist[next.to][curr.count + 1] = curr.weight;
                    pq.add(new Node(next.to, curr.weight, curr.count + 1));
                }
            }
        }

    }
}

class Node {
    int to;
    long weight;
    int count;

    public Node(int to, long weight) {
        this.to = to;
        this.weight = weight;
        this.count = 0;
    }
    public Node(int to, long weight, int count) {
        this.to = to;
        this.weight = weight;
        this.count = count;
    }
}

/*

*/
