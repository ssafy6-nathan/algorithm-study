import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] queue1, int[] queue2) {
        answer = 0;
        
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0L;
        long sum2 = 0L;
        
        for(int i = 0; i < queue1.length; i++){
            que1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i = 0; i < queue2.length; i++){
            que2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        int Max = 600000;
        while(true){
            if(que1.isEmpty() || que2.isEmpty() || Max < answer){
                answer = -1;
                break;
            }
            if(sum1 == sum2) break;
            if(sum1 > sum2){
                int temp = que1.poll();
                sum1 -= temp;
                que2.offer(temp);
                sum2 += temp;
            }else{
                int temp = que2.poll();
                sum2 -= temp;
                que1.offer(temp);
                sum1 += temp;
            }
            answer++;
        }
        
        
        return answer;
    }
}