package study.nathan_algo_study.week43;

import java.io.*;

/**
 * 문제이름 : 막대기
 * 링크 : https://www.acmicpc.net/problem/1094
 */

public class Baekjoon1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ruler = 64;
        int minLen = 64;
        int cnt = 1;
        while (ruler > n) {
            minLen >>= 1;
            if (ruler - minLen >= n)
                ruler -= minLen;
            else
                cnt++;
        }

        System.out.println(cnt);
    }
}

/*
64
32
16 16


*/
