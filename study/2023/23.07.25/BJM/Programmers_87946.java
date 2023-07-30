package week62;

/**
 * 프로그래머스 87946번
 * 피로도
 * (https://school.programmers.co.kr/learn/courses/30/lessons/87946)
 **/
public class Programmers_87946 {
    static boolean[] visited;
    static int max;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        max = Integer.MIN_VALUE;
        dfs(k, dungeons, visited);
        return max;
    }
    public static void dfs(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        // 탐험 가능한 던전 개수 확인
        for (int i = 0; i < visited.length; i++)
            if (visited[i]) count++;
        // 최대 던전 개수 갱신
        if (max < count) max = count;

        // 가능한 모든 경로를 검색함
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) { // 방문하지 않았으면서
                if (dungeons[i][0] <= k) { // 최소 필요 피로도를 충족할 때
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(k, dungeons, visited);
                    // 탐색이 완전히 끝난 시점에서 다른 경로 검색을 위해 원상태로 복구
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }
}
