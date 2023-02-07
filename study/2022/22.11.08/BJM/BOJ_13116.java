package week35;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 13116번
 * 30번 (https://www.acmicpc.net/problem/13116)
 * 분류 : 수학, 트리, 최소 공통 조상
 **/
public class BOJ_13116 {
    static boolean[] visited; // 방문 체크 (최대 노드 개수 1023)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T, A, B; // 테스트케이스, 노드1, 노드2
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            visited = new boolean[1024];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visit(A);
            bw.write((10 * check(B))+"\n");
        }
        bw.close();
    }

    // 방문 체크 (A)
    // 제시된 노드 번호에서 2로 나눈 몫이 부모 노드의 번호
    // 노드 A의 경우, 루트까지 계속2로 나누어 방문 체크
    private static void visit(int v) {
        if (v == 0) return;
        visited[v] = true;
        visit(v/2 );
    }

    // 최소 공통 조상 탐색 (B)
    // 노드 B의 경우, 2로 계속 나눠서 체크된 노드를 만나면 최소 공통 조상
    private static int check(int v) {
        if (visited[v]) return v;
        visited[v] = true;
        return check(v/2);
    }
}




