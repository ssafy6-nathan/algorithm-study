package study.nathan_algo_study.week15;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 완전 이진 트리
 * 링크 : https://www.acmicpc.net/problem/9934
 */

public class Baekjoon9934 {
    static int K;
    static Queue<Integer> input;
    static int[] tree;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        input = new LinkedList<>();
        K = Integer.parseInt(br.readLine());
        len = (int) (Math.pow(2, K));
        tree = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (len - 1); i++)
            input.add(Integer.parseInt(st.nextToken()));

        search(1);

        int floor = 1;
        for (int i = 1, j = 0; i < len; i++, j++) {
            if (j == floor) {
                bw.newLine();
                floor *= 2;
                j = 0;
            }

            bw.write(tree[i]+" ");
        }
        bw.close();
    }

    public static void search(int curr) {
        int left = curr*2;
        int right = curr*2+1;

        if (left < len) {
            search(left);
        }

        tree[curr] = input.poll();

        if (right < len) {
            search(right);
        }
    }
}


/*
왼쪽 탐색
현재 노드 탐색
오른쪽 탐색


0 1 2 3 4 5 6 7
x 3 6 2 1 4 5 7

1 6 4 3 5 2 7

0 1 2 3 4 5 6 7
x x x x x x x x


*/
