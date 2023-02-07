package study.nathan_algo_study.week44;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이가 빠진 이진 트리
 * 링크 : https://www.acmicpc.net/problem/26260
 */

public class Baekjoon26260 {
    static int[] inputTree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        inputTree = new int[N];
        sb = new StringBuilder();
        int deleteIdx = -1;
        for (int i = 0; i < N; i++) {
            inputTree[i] = Integer.parseInt(st.nextToken());
            if (inputTree[i] == -1)
                deleteIdx = i;
        }

        int x = Integer.parseInt(br.readLine());
        inputTree[deleteIdx] = x;
        Arrays.sort(inputTree);

        postOrder(0, N - 1);

        System.out.println(sb);

    }

    public static void postOrder(int start, int end) {
        if (start >= end) {
            sb.append(inputTree[start] + " ");
            return;
        }
        int mid = (start + end) / 2;
        postOrder(start, mid - 1);
        postOrder(mid + 1, end);

        sb.append(inputTree[mid] + " ");
    }
}

/*

*/
