package week33;

import java.io.*;

/**
 * 프로그래머스 12918번
 * 문자열 다루기 기본
 * (https://school.programmers.co.kr/learn/courses/30/lessons/12918)
 **/

public class Programmers_12918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solution(s));

    }

    private static boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6) {
            answer = true;
            for (int i = 0; i < s.length(); i++) {
                if (48 > s.charAt(i) || 57 < s.charAt(i)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
