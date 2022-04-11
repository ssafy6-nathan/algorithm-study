package study.nathan_algo_study.week7;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 보물
 * 링크 : https://www.acmicpc.net/problem/1026
 */

public class Baekjoon1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Integer[] b = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(b, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++)
            result += pq.poll() * b[i];

        System.out.println(result);
    }
}

/*
1 1 1 6 0

0 1 1 1 6
8 7 3 2 1



*/
