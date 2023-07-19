package week62;

/**
 * 프로그래머스 76501번
 * 음양 더하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/76501)
 **/
public class Programmers_76501 {
    public static void main(String[] args) {
        int[][] absolutes = {{4, 7, 12}, {1, 2, 3}};
        boolean[][] signs = {{true, false, true}, {false, false, true}};
        for (int i = 0; i < absolutes.length; i++)
            System.out.println(solution(absolutes[i], signs[i]));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0 ; i < absolutes.length ; i++) {
            if (signs[i]) answer += absolutes[i];
            else answer += (absolutes[i] - (2 * absolutes[i]));
        }
        return answer;
    }
}
