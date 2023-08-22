package study.nathan_algo_study.week63;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 좋은 단어
 * 링크 : https://www.acmicpc.net/problem/3986
 */

public class Baekjoon3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isGoodWord(br.readLine()))
                cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isGoodWord(String word) {
        Deque<Character> s = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (s.isEmpty())
                s.push(curr);
            else {
                if (s.peek() != curr)
                    s.push(curr);
                else
                    s.pop();
            }
        }

        return s.isEmpty();
    }
}

/*

*/
