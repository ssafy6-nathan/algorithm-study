package study.nathan_algo_study.week42;

import java.io.*;

/**
 * 문제이름 : 팩토리얼 0의 개수
 * 링크 : https://www.acmicpc.net/problem/1676
 */

public class Baekjoon1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        System.out.println(cnt);
    }
}

/*
10 9 8 7 6 5 4 3 2 1
2 5




*/
