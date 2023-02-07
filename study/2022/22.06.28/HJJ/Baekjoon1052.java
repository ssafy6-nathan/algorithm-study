package study.nathan_algo_study.week18;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 물병
 * 링크 : https://www.acmicpc.net/problem/1052
 */

public class Baekjoon1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int newBottleCnt = 0;
        while (Integer.bitCount(N++) > K)
            newBottleCnt++;

        System.out.println(newBottleCnt);
    }
}

/*
3 1
3 = 0011

2의 제곱수

13 = 1101
14 = 1110
15 = 1111
16 = 1 0000



*/
