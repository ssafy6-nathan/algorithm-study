import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1162_도로포장 {
    private static class Node {
        int v, count;
        long cost;

        Node(int v, long cost, int count) {
            this.v = v;
            this.cost = cost;
            this.count = count;
        }
    }

    static List<List<Node>> graph;
    static final long MAX = Long.MAX_VALUE;
    static long[][] dp;
    static int n, m, k;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dp = new long[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(dp[i], MAX);
        }
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w, 0));
            graph.get(e).add(new Node(s, w, 0));


        }

        dijkstra();
        long min = MAX;
        for (long a : dp[n]) {
            min = Math.min(a, min);
        }
        System.out.println(min);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        pq.add(new Node(1,  0, 0));
        dp[1][0] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dp[cur.v][cur.count]) continue;
            for (Node next : graph.get(cur.v)) {
                long nextCost = next.cost + cur.cost;
                if(nextCost < dp[next.v][cur.count]) {
                    dp[next.v][cur.count] = nextCost;
                    pq.add(new Node(next.v, nextCost, cur.count));
                }
                if (cur.count < k && cur.cost < dp[next.v][cur.count + 1]) {
                    dp[next.v][cur.count + 1] = cur.cost;
                    pq.add(new Node(next.v, cur.cost, cur.count + 1));
                }
            }
        }
    }
}
