import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int[] answers){
       int [] spj1 = {1,2,3,4,5};
        int [] spj2 = {2,1,2,3,2,4,2,5};
        int [] spj3 = {3,3,1,1,2,2,4,4,5,5};
        
        int [] spjPoint = new int[3];
        // 수포자들의 점수 계산한 후 각 점수 비교
        spjPoint[0] = point(spj1, answers);
        spjPoint[1] = point(spj2, answers);
        spjPoint[2] = point(spj3, answers);
        int result = -1;
        for(int i = 0; i < 3; i++){
            result = Math.max(result, spjPoint[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(result == spjPoint[i])
                list.add(i+1);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static int point(int[] spj, int[] answers) {//점수 계산
        int count = 0;
        for(int i = 0; i < answers.length; i++){
            if(spj[i%spj.length] == answers[i]){
                count++;                
            }
        }
        
        return count;
    }
    
}
