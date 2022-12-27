package study.nathan_algo_study.week24;

/**
 * 문제이름 : 타겟 넘버
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */

public class Programmers43165 {

    static int count;
    public int solution(int[] numbers, int target) {
        count = 0;
        perm(target, 0, new int[numbers.length], numbers);

        return count;
    }

    public void perm(int target, int cnt, int[] p, int[] numbers) {
        if (cnt == p.length) {
            int sum = 0;
            for (int i = 0; i < p.length; i++) {
                sum += (p[i] == 0)? -numbers[i] : numbers[i];
            }

            if (sum == target)
                count++;

            return;
        }

        p[cnt] = 0;
        perm(target, cnt+1, p, numbers);

        p[cnt] = 1;
        perm(target, cnt+1, p, numbers);
    }
}

/*

*/
