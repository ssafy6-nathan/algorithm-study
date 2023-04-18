package study.nathan_algo_study.week53;

/**
 * 문제이름 : 마법의 엘리베이터
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */

public class Programmers_마법의엘리베이터 {
    static int result;
    static String str;
    public int solution(int storey) {
        result = Integer.MAX_VALUE;
        str = String.valueOf(storey);
        recur(str.length() - 1, 0, 0);

        return result;
    }

    public void recur(int floor, int offset, int cnt) {
        if (floor == -1) {
           result = Math.min(result, cnt + offset);
           return;
        }

        int num = (str.charAt(floor) - 48) + offset;
        recur(floor - 1, 0, cnt + num);
        recur(floor - 1, 1, cnt + 10 - num);
    }
}

/*

 */
