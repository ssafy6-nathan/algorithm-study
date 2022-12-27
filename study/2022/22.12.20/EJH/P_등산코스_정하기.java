import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P_등산코스_정하기 {
    private static class Node {
        int v, cost; // 노드, 가중치

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
    static List<List<Node>> graph;
    //방문한 적이 있는지 체크하는 목적의 리스트
    static boolean[] visit;
    //최단 거리 테이블
    static int[] dist;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];

            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));


        }

        dijkstra(gates, summits);
        // 정상까지 갔을 때 최소이면 돌아올 때도 같은 경로를 선택하면 되므로
        // 정상까지 가는 경우만 고려
        int mn = Integer.MAX_VALUE; // 산봉우리 번호
        int mw = Integer.MAX_VALUE; // 최솟값

        // 정렬하지 않으면 12, 14, 15, 16, 17, 25번 문제 실패
        Arrays.sort(summits);

        for (int summit : summits) {
            if (dist[summit] < mw) {
                mn = summit;
                mw = dist[summit];
            }
        }
        return new int[]{mn, mw};
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{1, 2, 3},
                {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}
                },
                new int[]	{1, 3},
                new int[]	{5}));

        System.out.println(solution(7, new int[][] {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}},
                new int[]	{1},
                new int[]	{2, 3, 4}));

        System.out.println(solution(7, new int[][] 	{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}},
                new int[]	{3, 7},
                new int[]	{1, 5}));
    }


    static void dijkstra(int[] gates, int[] summits) {
        //우선 순위 큐 사용, 가중치를 기준으로 오름차순한다.
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        //시작 노드에 대해서 초기화
        for (int gate : gates){
            q.add(new Node(gate, 0));
            dist[gate] = 0;
        }

        List<Integer> summitList = new ArrayList<>();

        for (int summit : summits){
            summitList.add(summit);
        }


        while (!q.isEmpty()) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
            Node now = q.poll();

            if(now.cost > dist[now.v]) {
                continue;
            }

            if (summitList.contains(now.v)){
                continue;
            }

            for (Node next : graph.get(now.v)) {
                int dis = Math.max(dist[now.v], next.cost);
                if (dist[next.v] > dis) {
                    dist[next.v] = dis;
                    q.add(new Node(next.v, dis));
                }
            }
        }
    }


}
