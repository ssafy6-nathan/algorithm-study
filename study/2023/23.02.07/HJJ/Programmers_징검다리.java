package study.nathan_algo_study.week46;

import java.util.Arrays;

/**
 * 문제이름 : 징검다리
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */

public class Programmers_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 0;
        int end = distance;
        Arrays.sort(rocks);

        while (start <= end) {
            int mid = (start + end) / 2;    //정렬한 돌의 중간을 잡는다.
            int deleteRock = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid)  //중간값이 현재 돌에서 이전값을 뺀 것보다 크면
                    deleteRock++;       //돌 제거
                else
                    prev = rocks[i];    //이전값 갱신
            }
            if (distance - rocks[rocks.length-1] < mid) //중간값이 거리에서 마지막 돌을 뺀값보다 크면
                deleteRock++;   //돌 제거

            if (deleteRock <= n) {  //제거한 돌의 갯수가 n보다 작거나 같으면
                answer = mid;   //정답 갱신
                start = mid + 1;
            } else
              end = mid - 1;
        }

        return answer;
    }
}

/*
0 2 11 14 17 21 25

2 9 3 3 4 4

2 3 3 4 4 9



*/
