package week35;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 20364번
 * 부동산 다툼 (https://www.acmicpc.net/problem/20364)
 * 분류 : 트리
 **/

public class BOJ_20364 {
    static boolean[] isVisited; // 방문 체크 (노드 개수 N개)
    static int visit; // 방문한 노드 중 가장 상위에 있는 노드 저장
    static int node; // 현재 입력받은 땅 번호 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, Q; // 노드 개수, 오리 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1]; // 1번 배열부터 사용
        for (int i = 0; i < Q; i++) {
            visit = 0; // 땅을 가질 수 있으면 0을 출력하므로 초기화
            node = Integer.parseInt(br.readLine()); // 원하는 땅 번호 입력
            dfs(node);
            bw.write(visit + "\n");
        }
        bw.close();

    }

    // 입력받은 노드 번호로부터 상단 방향으로 탐색
    private static void dfs(int v) {
        if (v == 1) { // 루트까지 도달하면 탐색 종료
            // visit이 0이라면 방문 노드를 만나지 않았으므로 방문 체크하고 0 출력
            // visit이 0이 아니라면 이미 방문한 노드가 있으므로 땅을 가질 수 없음, 따라서 가장 상단 노드번호가 저장된 visit을 출력
            if (visit == 0) isVisited[node] = true;
            return;
        }
        if (isVisited[v]) visit = v; // 방문 노드를 만나면 노드 번호 저장
        dfs(v/2);
    }
}

// 제시된 땅 번호부터 위로 탐색
// 만약 방문한 노드를 만나면 따로 저장하고 루트까지 계속 탐색
// 루트까지 탐색했는데도 방문된 노드를 만나지 않았다면 처음 땅 번호의 방문 여부 체크하고 리턴
// 방문된 노드를 만나 저장된 노드 번호가 있다면 해당 번호 반환
