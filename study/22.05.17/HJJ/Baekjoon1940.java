package study.nathan_algo_study.week12;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 주몽
 * 링크 : https://www.acmicpc.net/problem/1940
 */

public class Baekjoon1940 {
    static int N, M;
    static int[] items;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        items = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            items[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(items);

        System.out.println(armorCnt());

    }

    public static int armorCnt() {
        int cnt = 0;
        int front = 0;
        int back = N - 1;
        int curr;
        while (front < back) {
            curr = items[front] + items[back];
            if (curr == M) {
                cnt++;
                front++;
                back--;
            } else if (curr < M) {
                front++;
            } else {    //curr > M
                back--;
            }
        }

        return cnt;
    }
}

/*
2 7 4 1 5 3

1 2 3 4 5 7



*/
