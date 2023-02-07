package study.nathan_algo_study.week37;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 망가진 키보드
 * 링크 : https://www.acmicpc.net/problem/6503
 */

public class Baekjoon6503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m;
        String str;
        Map<Character, Integer> map;
        while ((m = Integer.parseInt(br.readLine())) != 0) {
            str = br.readLine();
            map = new HashMap<>();
            int left = 0;
            int right = 0;
            int max = 0;
            while (right < str.length()) {
                char c = str.charAt(right);
                char p = str.charAt(left);
                if (map.size() > m) {
                    int value = map.get(p);
                    if (value == 1)
                        map.remove(p);
                    else
                        map.put(p, value - 1);
                    left++;
                } else {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    right++;
                }

                if (map.size() <= m)
                    max = Math.max(max, right - left);
            }

            bw.write(max+"\n");
        }
        bw.close();
    }
}

/*
Mississippi


*/
