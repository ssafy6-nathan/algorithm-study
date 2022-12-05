package study.nathan_algo_study.week39;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 단어 수학
 * 링크 : https://www.acmicpc.net/problem/1339
 */

public class Baekjoon1339 {
    static Character[] alphabets;
    static int N;
    static int maxValue;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        words = new String[N];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = input;
            for (int j = 0; j < input.length(); j++)
                set.add(input.charAt(j));
        }

        maxValue = 0;
        alphabets = set.toArray(new Character[0]);
        perm(0, alphabets.length, new int[alphabets.length], new boolean[10]);

        System.out.println(maxValue);
    }

    public static void perm(int cnt, int n, int[] p, boolean[] v) {
        if (cnt == n) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(alphabets[i],p[i]);
            }

            findMaxSum(map);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (v[i])
                continue;

            p[cnt] = i;
            v[i] = true;
            perm(cnt+1, n, p, v);
            v[i] = false;
        }
    }

    public static void findMaxSum(Map<Character, Integer> map) {
        StringBuilder num;
        int result = 0;
        for (String s : words) {
            num = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
                num.append(map.get(s.charAt(i)));

            result += Integer.valueOf(num.toString());
        }

        maxValue = Math.max(maxValue, result);
    }
}

/*

*/
