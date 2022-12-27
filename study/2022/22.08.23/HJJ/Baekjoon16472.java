package study.nathan_algo_study.week26;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 고냥이
 * 링크 : https://www.acmicpc.net/problem/16472
 */

public class Baekjoon16472 {
    static Map<Character, Integer> map;
    static int N;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        map = new HashMap<>();

        System.out.println(solution());
    }

    public static int solution() {
        int currLen = 0;
        int left = 0;
        int right = 0;
        while (right < str.length() && map.size() <= N) {
            char c = str.charAt(right++);
            if (map.containsKey(c)) {
                int currCnt = map.get(c);
                map.put(c, currCnt + 1);
            } else {
                if (map.size() == N) {
                    right--;
                    break;
                }
                map.put(c, 1);
            }
            currLen++;
        }

        int maxLen = currLen;

        while (right < str.length()) {
            if (map.size() <= N) {
                maxLen = Math.max(currLen, maxLen);
                char c = str.charAt(right++);
                if (map.containsKey(c)) {
                    int currCnt = map.get(c);
                    map.put(c, currCnt + 1);
                } else {
                    map.put(c, 1);
                }
                currLen++;
            } else {
                char c = str.charAt(left++);
                int currCnt = map.get(c);
                if (currCnt == 1) {
                    map.remove(c);
                } else
                    map.put(c, currCnt - 1);
                currLen--;
            }
        }

        return maxLen;
    }
}

/*
1
aabbbccdcccccdez
  l r

 */
