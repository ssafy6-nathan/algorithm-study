package week35;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 11725번
 * 트리의 부모찾기 (4) (https://www.acmicpc.net/problem/11725)
 * 분류 : 그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색
 **/
public class BOJ_11725 {
    static int[] parent; // 부모 노드 번호 저장
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n1, n2;
        int N = Integer.parseInt(br.readLine()); // 노드의 개수 입력
        parent = new int[N];
        visited = new boolean[N];
        list = new ArrayList[N];

        for (int i = 0; i < list.length; i++) // 인접리스트 생성
            list[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) { // 연결 정보 입력
            st = new StringTokenizer(br.readLine());
            n1 = (Integer.parseInt(st.nextToken()) - 1);
            n2 = (Integer.parseInt(st.nextToken()) - 1);
            list[n1].add(n2);
            list[n2].add(n1);
        }

        dfs(0);

        for (int i = 1; i < parent.length; i++)
            bw.write(parent[i] + "\n");
        bw.close();
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int vertex : list[v]) {
            if (!visited[vertex]) {
                parent[vertex] = v + 1;
                dfs(vertex);
            }
        }
    }
}
