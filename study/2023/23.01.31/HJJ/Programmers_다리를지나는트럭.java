package study.nathan_algo_study.week45;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 문제이름 : 다리를 지나는 트럭
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */

public class Programmers_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Item> bridge = new LinkedList<>();
        int currWeight = 0;
        int resultTime = 0;
        for (int i = 0, t = 1; i < truck_weights.length || !bridge.isEmpty(); t++) {
            if (!bridge.isEmpty()) {
                if (t >= bridge.peek().time + bridge_length) {
                    currWeight -= bridge.peek().weight;
                    bridge.poll();
                    resultTime = t;
                }
            }
            if (i < truck_weights.length && weight >= currWeight + truck_weights[i]) {
                bridge.add(new Item(truck_weights[i], t));
                currWeight += truck_weights[i++];
            }
        }

        return resultTime;
    }
}

class Item {
    int weight;
    int time;

    public Item(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

/*
10

101


*/
