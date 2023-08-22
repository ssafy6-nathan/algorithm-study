package study.nathan_algo_study.week63;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : UCPC는 무엇의 약자일까?
 * 링크 : https://www.acmicpc.net/problem/15904
 */

public class Baekjoon15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ucpc = {'U', 'C', 'P', 'C'};

        int idx = 0;
        String inputString = br.readLine();

        for (int i = 0; i < inputString.length(); i++) {
            if (idx == 4)
                break;

            if (inputString.charAt(i) == ucpc[idx])
                idx++;
        }

        if (idx == 4)
            System.out.println("I love UCPC");
        else
            System.out.println("I hate UCPC");
    }
}

/*
전체 문자열을 순회하면서 UCPC 문자가 순서대로 나오는지 체크


*/
