package study.nathan_algo_study.week52;

import java.util.*;

/**
 * 문제이름 : 과제 진행하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */

public class Programmers_과제진행하기 {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));

        int plansIdx = 0;
        Deque<Task> stack = new ArrayDeque<>();
        stack.push(new Task(plans[plansIdx++]));

        while (plansIdx < plans.length) {
            Task peek = stack.peek();
            int currTime = peek.startTime;
            int nextStartTime = changeTime(plans[plansIdx][1]);
            //새로운 과제 시작할 시간인데 이전 과제가 안끝났으면
            if (currTime + peek.playTime > nextStartTime) {
                peek.playTime = currTime + peek.playTime - nextStartTime;
                stack.push(new Task(plans[plansIdx++]));
            }
            //과제를 끝낸시간에 새로 시작해야하는 과제가 있으면
            else if (currTime + peek.playTime == nextStartTime) {
                answer.add(stack.pop().name);
                stack.push(new Task(plans[plansIdx++]));
            }
            //과제를 끝낸시간에 다음 과제가 없으면
            else {
                answer.add(stack.pop().name);
                if (!stack.isEmpty()) {
                    stack.peek().startTime = currTime + peek.playTime;
                }
            }

            if (stack.isEmpty())
                stack.push(new Task(plans[plansIdx++]));
        }

        while (!stack.isEmpty())
            answer.add(stack.pop().name);

        return answer.stream().toArray(String[]::new);
    }

    public static int changeTime(String time) {
        String[] timeParse = time.split(":");
        int hour = Integer.parseInt(timeParse[0]);
        int min = Integer.parseInt(timeParse[1]);
        return hour * 60 + min;
    }

    static class Task {
        public String name;
        public int startTime;
        public int playTime;

        public Task(String[] plan) {
            this.name = plan[0];
            this.startTime = changeTime(plan[1]);
            this.playTime = Integer.parseInt(plan[2]);
        }
    }
}



/*

a 0 20
b 10 30
c 40 10

a () {}
b (a:10) {}
c (a:10) {b}
a () {b,c}
() {b,c,a}

1. 과제 시작
2.

*/
