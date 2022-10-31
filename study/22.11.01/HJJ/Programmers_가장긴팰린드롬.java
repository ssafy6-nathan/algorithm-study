package study.nathan_algo_study.week34;

/**
 * 문제이름 : 가장 긴 팰린드롬
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12904
 */

public class Programmers_가장긴팰린드롬 {
    public int solution(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; i + j <= s.length(); j++) {
                if (isPalindrome(s, j, j + i - 1))
                    return i;
            }
        }

        return 0;
    }

    public boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }

        return true;
    }
}

/*

 */
