package week45;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 42583번
 * 다리를 지나는 트럭
 * (https://school.programmers.co.kr/learn/courses/30/lessons/42583)
 **/

public class Programmers_42583 {
    public static void main(String[] args) {
        int[] bridge_length = {2, 100, 100};
        int[] weight = {10, 100, 100};
        int[][] truck_weights = {{7, 4, 5, 6}, {10}, {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}};
        for (int i = 0; i < truck_weights.length; i++) {
            System.out.println(solution(bridge_length[i], weight[i], truck_weights[i]));
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckNum = 0; // 트럭 포인터
        int weightCheck = 0; // 다리 위 트럭 무게 측정
        Queue<Integer> bridge = new LinkedList<>();

        while (true) {
            // 탈출 조건: 트럭을 모두 다리에 올렸을 때
            if (truckNum >= truck_weights.length) break;

            // 0. 현재 트럭 받아오기
            int curTruck = truck_weights[truckNum];

            // 1. 현재 다리에 빈 자리가 있는지 확인
            if (bridge.size() < bridge_length) {
                // 2. 현재 트럭이 다리에 올릴 수 있는 무게인지 확인
                if ((weightCheck + curTruck) <= weight) {
                    bridge.add(curTruck);
                    weightCheck += curTruck;
                    truckNum++; // 트럭을 올렸으면 다음 트럭을 가리키게 하기
                }
                // + 다리에 올릴 수 없다면 0을 삽입 (트럭을 넣지 않아도 다리위 트럭이 움직이게 함)
                else {
                    bridge.add(0);
                }
            }
            // 빈 자리가 없을 경우 트럭을 다리에서 꺼냄 (이때 시간은 흐르지 않으므로 continue)
            else {
                weightCheck -= bridge.poll();
                continue;
            }
            answer++;
        }
        // 트럭이 모두 올라간 시점에서 반복을 종료하므로 모두 건너가는 시점을 답으로 반환
        return answer + bridge_length;
    }
}
