package study.nathan_algo_study.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 나무 자르기
 * 링크 : https://www.acmicpc.net/problem/2805
 */

public class Baekjoon2805 {
    static int N;
    static long M;
    static long[] tree;
    static long maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        tree = new long[N];
        st = new StringTokenizer(br.readLine());

        long maxValue = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            maxValue = Math.max(tree[i], maxValue);
        }

        maxHeight = 0;
        binarySearch(0, maxValue);

        System.out.println(maxHeight);
        br.close();
    }

    public static void binarySearch(long start, long end) {
        if (start > end)
            return;

        long mid = (start + end) / 2;
        long sum = calHeight(mid);

        if (sum >= M) {
            maxHeight = Math.max(maxHeight, mid);
            binarySearch(mid + 1, end);
        }
        else if (sum < M)
            binarySearch(start, mid - 1);

    }

    private static long calHeight(long height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] - height > 0)
                sum += tree[i] - height;
        }

        return sum;
    }
}

/*
4 26 40 42 46

23
3 17 19 23 = 62
36
4 6 10 = 20


10 15 17 20

10 (0, 20)
5 7 10 = 22
15(10, 20)
2 5 = 7
12(10, 15)
3 5 8 = 16
13(12, 15)
2 4 7 = 13
14(13, 15)
1 3 6 = 10

1 2 6
2

3 5
2 3 7


*/
