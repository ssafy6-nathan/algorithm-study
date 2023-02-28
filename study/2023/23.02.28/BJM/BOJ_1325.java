package week48;

import java.io.*;
import java.util.*;

/**
 * 백준 1325번
 * 효율적인 해킹 (https://www.acmicpc.net/problem/1325)
 * 분류 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 너비 우선 탐색
 **/
public class BOJ_1325 {
    static int N;
    static int M;
    static int count;
    static int[] num;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1];

        // 1. 인접리스트 생성
        graph = new ArrayList[N+1];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        // 2. 인접리스트 채우기
        // A - B 신뢰관계에서 B를 해킹하면 A도 해킹이 가능하다. (※ 그러나 반대는 성립하지 않음)
        // 따라서 가독성을 위해 간선 방향을 해킹 전파 방향(B -> A)으로 설정함
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        
        // 3. bfs + 해킹 가능한 최대 컴퓨터 수 갱신
        int max = 0;
        for (int i = 1; i < graph.length; i++) {
            count = 0;
            bfs(i);
            num[i] = count;
            max = Math.max(count, max);
        }

        // 4. 가장 많은 컴퓨터를 해킹할 수 있는 노드번호 탐색
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < graph.length; i++) {
            if(num[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(node);
        boolean[] visit = new boolean[N+1];
        visit[node] = true;

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int nextNode : graph[currNode]) {
                if(visit[nextNode])
                    continue;
                queue.offer(nextNode);
                visit[nextNode] = true;
                count++;
            }
        }
    }
}
