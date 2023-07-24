package study.nathan_algo_study.week62;

/**
 * 문제이름 : 음양 더하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76501
 */

public class Programmers_음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }
}

/*

*/
