package study.nathan_algo_study.week31;

import java.io.*;

/**
 * 문제이름 : 단어 공부
 * 링크 : https://www.acmicpc.net/problem/1157
 */

public class Baekjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        int[] alphabets = new int[26];
        for (int i = 0; i < str.length(); i++)
            alphabets[str.charAt(i) - 65]++;

        int max = 0;
        char maxChar = '?';

        for (int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] > max) {
                max = alphabets[i];
                maxChar = (char)(i + 65);
            }
            else if(alphabets[i] == max)
                maxChar = '?';
        }

        System.out.println(maxChar);
    }
}

/*

*/
