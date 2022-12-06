package study.nathan_algo_study.week30;

import java.io.*;

/**
 * 문제이름 : 피보나치 함수
 * 링크 : https://www.acmicpc.net/problem/1003
 */

public class Baekjoon1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int zeroCnt = 1;
            int oneCnt = 0;
            int sumCnt = 1;

            for (int i = 0; i < n; i++) {
                zeroCnt = oneCnt;
                oneCnt = sumCnt;
                sumCnt = zeroCnt + oneCnt;

            }

            bw.write(zeroCnt + " " + oneCnt + "\n");
        }
        bw.close();

    }

}

/*
1 0
0 1
1 1
1 2
2 3
3 5
5 8
8 13
13 21

zeroCnt = (n-1)의 oneCnt
oneCnt = (n-1)의 zeroCnt + oneCnt



 */
