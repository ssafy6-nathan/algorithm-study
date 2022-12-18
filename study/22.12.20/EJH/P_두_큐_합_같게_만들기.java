import java.util.ArrayDeque;
import java.util.Queue;

public class P_두_큐_합_같게_만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        long limit = queue1.length + queue2.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int t : queue1){
            q1.add(t);
            sum1 += t;
        }

        for (int t : queue2){
            q2.add(t);
            sum2 += t;
        }

        if ((sum1 + sum2) % 2 == 1){
            return -1;
        }

        while (answer <= limit * 2){
            if (sum1 == sum2){
                return answer;
            } else if (sum1 > sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            answer += 1;

        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2},	new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2},	new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1},	new int[]{1, 5}));
    }
}
