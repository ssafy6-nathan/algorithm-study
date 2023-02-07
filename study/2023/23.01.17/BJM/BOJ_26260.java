import java.io.*;
import java.util.*;

/**
 * 백준 26260번
 * 이가 빠진 이진 트리 (https://www.acmicpc.net/problem/26260)
 * 분류 : 그래프 이론, 그래프 탐색, 정렬, 트리, 깊이 우선 탐색, 재귀
 **/

public class BOJ_26260 {
    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, X;
        int idx = -1;
        N = Integer.parseInt(br.readLine()); // 노드개수
        nodes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == -1) idx = i;
            nodes[i] = val;
        }
        X = Integer.parseInt(br.readLine()); // 지워진 노드를 X로 채우기
        nodes[idx] = X;
        Arrays.sort(nodes); // 오름차순 정렬

        postOrder(0, N - 1);
    }

    public static void postOrder(int start, int end) {
        if (start >= end) {
            System.out.print(nodes[start] + " ");
            return;
        }

        int mid = (start + end) / 2;

        postOrder(start, mid - 1);
        postOrder(mid + 1, end);
        System.out.print(nodes[mid] + " ");
    }
}