package study.nathan_algo_study.week25;

import java.io.*;

/**
 * 문제이름 : 다이어트
 * 링크 : https://www.acmicpc.net/problem/1484
 */

public class Baekjoon1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] num = new long[100001];
        for (int i = 1; i < 100001; i++) {
            long n = i;
            num[i] = n * n;
        }

        int G = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 2;
        boolean isFind = false;

        while (right < 100000) {
            long curr = num[right] - num[left];
            if (curr == G) {
                bw.write(right+"\n");
                isFind = true;
            }

            if (curr > G)   //현재 값이 G보다 크면
                left++; //왼쪽값을 키워줌
            else
                right++;
        }

        if (!isFind)
            bw.write(-1+"\n");

        bw.close();
    }
}

/*
1
4
9
16
25
36
49
64
81
100
121

16 1
4  1

64 49
8  7
*/
