package week58;

import java.io.*;
import java.util.*;

/**
 * 백준 2644번
 * 촌수계산 (https://www.acmicpc.net/problem/2644)
 * 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 **/
public class BOJ_2644 {
    static int N, M; // N: 구성원 수, M: 부모 자식 관계 개수
    static int t1, t2; // 촌수 계산 대상 1, 2
    static int minCnt; // 촌수 계산 변수
    static List<Integer>[] graph;  // 인접 리스트
    static boolean[] visit; // 방문 체크
    static boolean isTarget; // 노드 발견 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        // 인접 리스트 생성
        for (int i = 0; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        // 연결 관계 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        visit = new boolean[N + 1];
        visit[t1] = true;
        isTarget = false;
        minCnt = Integer.MAX_VALUE;
        dfs(t1, visit, 0);

        if (isTarget) System.out.println(minCnt);
        else System.out.println(-1);

    }

    public static void dfs (int curNode, boolean[] v, int cnt) {
        if (curNode == t2) { // 타겟을 만나면 재귀 종료
            isTarget = true;
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for (int next: graph[curNode]) { // 연결된 노드 방문
            if (v[next]) continue;
            v[next] = true;
            dfs(next, v, cnt + 1);
            v[next] = false;
        }
    }
}