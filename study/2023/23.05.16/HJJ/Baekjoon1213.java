package study.nathan_algo_study.week56;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 팰린드롬 만들기
 * 링크 : https://www.acmicpc.net/problem/1213
 */

public class Baekjoon1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = br.readLine();

        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++)
            counts[input.charAt(i) - 'A']++;

        int oddCnt = 0;
        int oddIdx = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                oddCnt++;
                oddIdx = i;
            }
        }
        Deque<Character> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        if (oddCnt > 1) {
            bw.write("I'm Sorry Hansoo");
        } else {
            if (oddCnt == 1) {
                result.addFirst((char)('A' + oddIdx));
                counts[oddIdx]--;
            }

            for (int i = counts.length - 1; i >= 0; i--) {
                while (counts[i] / 2 > 0) {
                    result.addFirst((char) ('A' + i));
                    result.addLast((char) ('A' + i));
                    counts[i] -= 2;
                }
            }
            for (char c : result)
                bw.write(c);
        }
        bw.close();


    }
}

/*
안되는 경우
1. 알파벳 갯수가 홀수인 경우가 2개이상일때


*/
