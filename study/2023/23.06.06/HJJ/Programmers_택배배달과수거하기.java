package study.nathan_algo_study.week57;

/**
 * 문제이름 : 택배배달과 수거하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */

public class Programmers_택배배달과수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliCnt = 0;
        int pickCnt = 0;

        for (int i = deliveries.length - 1; i >= 0; i--) {
            int move = 0;
            //이전에 오버된 값을 현재 값에 반영
            deliveries[i] += deliCnt;
            pickups[i] += pickCnt;

            //현재 지점(i)에 몇번을 이동해야 배달이 끝나는지 확인
            while (deliveries[i] > 0 || pickups[i] > 0) {
                deliveries[i] -= cap;
                pickups[i] -= cap;
                move++;
            }

            //위의 while문에서 오버된 값을 저장 (음수가 된 값)
            deliCnt = deliveries[i];
            pickCnt = pickups[i];

            //이동한 횟수만큼 이동거리 계산해서 더하기
            answer += 2 * (i + 1) * move;
        }

        return answer;
    }


}

/*
1/0 0/3 3/0 1/4 2/0

1/0 0/2 2/0 0/1 1/0 0/2 2/0




*/
