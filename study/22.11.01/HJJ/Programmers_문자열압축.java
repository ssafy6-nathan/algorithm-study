package study.nathan_algo_study.week34;

/**
 * 문제이름 : 문자열 압축
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */

public class Programmers_문자열압축 {
    public int solution(String s) {
        int n = s.length();
        String temp1, temp2;
        int count;
        int minLength = n;
        StringBuilder compressResult;
        for (int i = 1; i <= n / 2; i++) {
            count = 1;
            compressResult = new StringBuilder();

            temp1 = s.substring(0, i);
            for (int j = i; j < n; j += i) {
                if (j + i >= n)
                    temp2 = s.substring(j);
                else
                    temp2 = s.substring(j, j + i);

                if (temp1.equals(temp2))
                    count++;
                else {
                    if (count > 1) {
                        compressResult.append(count);
                        compressResult.append(temp1);
                    }
                    else
                        compressResult.append(temp1);
                    temp1 = temp2;
                    count = 1;
                }

                if (j + i >= n) {
                    if (count > 1) {
                        compressResult.append(count);
                        compressResult.append(temp1);
                    }
                    else
                        compressResult.append(temp1);
                }

            }

            if (minLength > compressResult.length())
                minLength = compressResult.length();

        }
        return minLength;
    }
}
