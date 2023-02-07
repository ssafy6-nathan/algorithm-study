package week45;

/**
 * 프로그래머스 43162번
 * 네트워크
 * (https://school.programmers.co.kr/learn/courses/30/lessons/43162)
 **/
public class Programmers_43162 {
    public static void main(String[] args) {
        int[] n = {3, 3};
        int[][][] computers = {{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1,}, {0, 1, 1}}};
        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], computers[i]));
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue; // 방문한 컴퓨터면 건너뛰기
            dfs(i, computers, visit, n);
            answer++; // 탐색이 끝나면 하나의 네트워크 탐색 완료
        }
        return answer;
    }

    private static void dfs(int pos, int[][] computers, boolean[] v, int n) {
        v[pos] = true; // 방문체크
        
        // 자기자신, 이미 방문된 컴퓨터, 연결되지 않은 컴퓨터일 경우 건너뛰기
        for (int i = 0; i < n; i++) {
            if (i == pos || v[i] || computers[pos][i] == 0) continue;
            dfs(i, computers, v, n);
        }
    }
}
