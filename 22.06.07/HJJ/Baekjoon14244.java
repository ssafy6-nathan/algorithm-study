package study.nathan_algo_study.week15;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 트리 만들기
 * 링크 : https://www.acmicpc.net/problem/14244
 */

public class Baekjoon14244 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M - 1; i++) //리프노드 먼저 출력 (M-1개의 리프노드)
            System.out.println(i + " " + (M - 1));

        for (int i = M - 1; i < N - 1; i++) //마지막 리프노드 + 중간 노드
            System.out.println(i + " " + (i + 1));

    }
}

/*
리프노드 M개



 */
