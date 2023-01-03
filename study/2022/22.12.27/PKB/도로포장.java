import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Node>[] list;
    static long[][] dp;

    private static class Node {

        int edge, cnt;
        long weight;

        private Node(int edge, long weight, int cnt) {

            this.edge = edge;
            this.weight = weight;
            this.cnt = cnt;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dp = new long[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w, 0));
            list[e].add(new Node(s, w, 0));
        }

        System.out.println(dijkstra());

    }

    private static long dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));
        pq.add(new Node(1, 0, 0));
        dp[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int e = cur.edge;
            int c = cur.cnt;
            long w = cur.weight;

            if (w > dp[e][c]) continue;

            for (Node next : list[e]) {
                // 도로 포장
                if (c < K && dp[next.edge][c + 1] > w) {
                    dp[next.edge][c + 1] = w;
                    pq.add(new Node(next.edge, w, c + 1));
                }

                long nw = w + next.weight;

                // 도로 포장 X
                if (dp[next.edge][c] > nw) {
                    dp[next.edge][c] = nw;
                    pq.add(new Node(next.edge, nw, c));
                }
            }
        }

        return Arrays.stream(dp[N]).min().getAsLong();

    }

}
