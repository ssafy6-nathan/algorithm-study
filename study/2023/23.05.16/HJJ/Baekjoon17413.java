package study.nathan_algo_study.week56;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 단어 뒤집기 2
 * 링크 : https://www.acmicpc.net/problem/17431
 */

public class Baekjoon17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = br.readLine();
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean inTag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                inTag = true;
                result.append(word.reverse());
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
                word = new StringBuilder();
            } else if (inTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    result.append(word.reverse());
                    result.append(c);
                    word = new StringBuilder();
                } else {
                    word.append(c);
                }
            }
        }
        if (word.length() != 0)
            result.append(word.reverse());

        System.out.println(result);
    }
}

/*

*/
