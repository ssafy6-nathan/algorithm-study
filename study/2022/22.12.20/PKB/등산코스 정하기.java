import java.util.*;

class Solution {

    static List<Node>[] map;
    static Set<Integer> gateSet, summitSet;
    static int[] intensity;
    static int resultNode, minIntensity;

    private static class Node {

        int e, w;

        private Node(int e, int w) {

            this.e = e;
            this.w = w;

        }

    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        map = new ArrayList[n + 1];
        gateSet = new HashSet<>();
        summitSet = new HashSet<>();
        intensity = new int[n + 1];
        resultNode = Integer.MAX_VALUE;
        minIntensity = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int gate : gates) {
            gateSet.add(gate);
        }

        for (int summit : summits) {
            summitSet.add(summit);
        }

        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];

            if (!gateSet.contains(i) && !summitSet.contains(j)) map[j].add(new Node(i, w));
            if (!gateSet.contains(j) && !summitSet.contains(i)) map[i].add(new Node(j, w));
        }

        dijkstra(n, gates, summits);

        return new int[]{resultNode, minIntensity};

    }

    private static void dijkstra(int n, int[] gates, int[] summits) {

        Queue<Node> queue = new ArrayDeque<>();
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 출입구 큐에 넣기 (시작점의 가중치는 0)
        for (int gate : gates) {
            queue.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int e = cur.e;
            int w = cur.w;

            if (intensity[e] < w) continue;

            for (Node next : map[e]) {
                int ne = next.e;
                int nw = next.w;
                int dis = Math.max(intensity[e], nw);

                if (intensity[ne] > dis) {
                    intensity[ne] = dis;
                    queue.add(new Node(ne, dis));
                }
            }
        }

        Arrays.sort(summits);

        for (int summit : summits) {
            if (minIntensity > intensity[summit]) {
                minIntensity = intensity[summit];
                resultNode = summit;
            }
        }

    }

}
