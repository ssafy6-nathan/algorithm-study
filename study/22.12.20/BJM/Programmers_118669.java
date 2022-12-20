package week41;

import java.util.*;

/**
 * 프로그래머스 118669번
 * 등산코스 정하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/118669)
 **/
public class Programmers_118669 {
    private static List<Node>[] node; // 노드의 연결 정보 저장
    private static int[] intensity; // intensity 정보 저장

    public static void main(String[] args) {
        int[] n = {6, 7, 7, 5};
        int[][][] paths =
                {{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
                {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}},
                {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}},
                {{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}}};
        int[][] gate = {{1, 3}, {1}, {3, 7}, {1, 2}};
        int[][] summits = {{5}, {2, 3, 4}, {1, 5}, {5}};

        for (int i = 0; i < n.length; i++) {
            System.out.println(Arrays.toString(solution(n[i], paths[i], gate[i], summits[i])));
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 1. 연결리스트와 intensity 배열 선언
        node = new List[n+1];
        intensity = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            node[i] = new ArrayList<>();
        }

        // 2. 노드 연결리스트에 값 추가 (+ 단방향 노드 처리)
        // 출입구인 경우 : 출입구 -> 다른노드
        // 산봉우리인 경우 : 다른노드 -> 산봉우리
        for (int[] path: paths) {
            if (isGate(path[0], gates) || isSummit(path[1], summits)) {
                node[path[0]].add(new Node(path[1], path[2]));
            } else if (isGate(path[1], gates) || isSummit(path[0], summits)) {
                node[path[1]].add(new Node(path[0], path[2]));
            } else {
                node[path[0]].add(new Node(path[1], path[2]));
                node[path[1]].add(new Node(path[0], path[2]));
            }

        }
        return dijkstra(n, gates, summits);
    }

    static class Node {
        int e; // 연결된 (목적) 노드 정보
        int w; // 에지의 가중치

        public Node (int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> queue = new LinkedList<>();
        Arrays.fill(intensity, Integer.MAX_VALUE); // 적당히 큰 값으로 초기화

        for (int gate: gates) { // 출입구 전부 넣고 시작 (출입구마다 다익스트라를 실행할 필요가 없음)
            queue.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            // 현재 가중치가 더 커서 최소값으로 갱신되지 못한다면 건너뜀
            if (curNode.w > intensity[curNode.e]) continue;

            for(Node next : node[curNode.e]) {
                // 현재까지 갱신된 intensity와 다음 경로의 가중치 중 큰 값을 선택
                int distance = Math.max(intensity[curNode.e], next.w);
                // intensity(경로 상 최대 가중치) 갱신
                if (intensity[next.e] > distance) {
                    intensity[next.e] = distance;
                    queue.add(new Node(next.e, distance));
                }
            }
        }

        Arrays.sort(summits); // intensity 값이 같을 경우 작은 산봉우리부터 출력하기위함
        int summitNum = Integer.MAX_VALUE;
        int minWeight = Integer.MAX_VALUE;
        // 산봉우리까지 가는 경로의 intensity를 비교하여 최소값을 갖는 경로를 찾아 산봉우리 번호와 가중치 출력
        for (int summit : summits) {
            if (intensity[summit] < minWeight) {
                minWeight = intensity[summit];
                summitNum = summit;
            }
        }
        return new int[] {summitNum, minWeight};
    }

    // 출입구 판별
    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }
    // 산봉우리 판별
    private static boolean isSummit(int num, int[] submits) {
        for (int submit : submits) {
            if (num == submit) return true;
        }
        return false;
    }
}
