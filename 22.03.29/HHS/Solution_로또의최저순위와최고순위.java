import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;//같은 번호 카운트
        int zero_count = 0;//안보이는 숫자 개수

        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j< win_nums.length; j++){
                //같은 것이 있으면 카운트 올리기
                if(win_nums[j] == lottos[i]){
                    count++;
                }
            }
            if(lottos[i] == 0) zero_count++;
        }
        
        int[] answer = new int[2];
        answer[0] = 7-count-zero_count;
        answer[1] = 7-count;

        for(int i = 0; i < 2; i++){
            if(answer[i] > 6)
                answer[i] = 6;
        }
        return answer;
    }
}