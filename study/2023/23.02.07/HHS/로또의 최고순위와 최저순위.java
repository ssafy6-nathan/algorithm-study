import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero_count = 0;
        for(int i=0; i < lottos.length; i++){
            for(int j =0; j<win_nums.length; j++){
                if(win_nums[j] == lottos[i]){
                    count++;
                }
            }
            if(lottos[i] == 0) zero_count++;
        }
        
        int[] answer = new int[2];
        answer[0] = 7-count-zero_count;
        answer[1] = 7-count;
        for(int i = 0; i<2; i++){
            if(answer[i] >6)
                answer[i] = 6;
        }
        return answer;
    }
}
