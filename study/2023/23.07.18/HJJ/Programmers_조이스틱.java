package study.nathan_algo_study.week61;

/**
 * 문제이름 : 조이스틱
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * https://developingbear.tistory.com/169
 */

public class Programmers_조이스틱 {
    public int solution(String name) {
        int[] cost = new int[name.length()];
        int answer = 0;

        for (int i = 0; i < cost.length; i++)
            answer += Math.min(name.charAt(i) - 'A', 'Z' + 1 - name.charAt(i)); //알파벳변경 코스트 계산

        int moveCnt = Integer.MAX_VALUE;
        for (int i = 0; i < name.length(); i++) {
            int nextIdx = i + 1;   //현재 알파벳 이후 처음 만나는 A가 아닌 알파벳 인덱스
            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A')
                nextIdx++;

            //i에 있는 알파벳이 A이면서 name의 마지막 인덱스이면
            if (name.charAt(i) == 'A' && nextIdx == name.length() + 1)
                break;

            //좌측, 우측으로 이동하는 포인터
            int right = i * 2 + name.length() - nextIdx;
            int left = i + (name.length() - nextIdx) * 2;
            moveCnt = Math.min(moveCnt, Math.min(left, right));
        }

        return answer + moveCnt;    //알파벳변경 코스트 + 이동 코스트
    }
}

/*
A 1
Y 25

24
26

26 - 24 = 2
24 - 26 = -2 + 26 = 24

9 0 1

왼쪽 코스트 2
오른쪽 코스트 3

XX0000XX
11000111

01000111 왼:6 오:
^
*/
