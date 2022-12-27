package study.nathan_algo_study.week10;

import java.io.*;
import java.util.HashSet;

/**
 * 문제이름 : 그룹 단어 체커
 * 링크 : https://www.acmicpc.net/problem/1316
 */

public class Baekjoon1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++)  {
            String word = br.readLine();
            if (groupWordCheck(word))
                cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean groupWordCheck(String word) {
        HashSet<Character> set = new HashSet<>();

        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (set.contains(c))
                return false;

            if (prev != c) {
                set.add(prev);
                prev = c;
            }
        }

        return true;
    }
}

/*

*/
