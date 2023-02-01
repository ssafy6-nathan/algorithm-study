import java.util.*;
public class P_모의고사 {

    class Solution {
        public int[] solution(int[] answers) {
            int[] score = {0, 0, 0, 0};
            int[][] students = {{1,2,3,4,5},
                    {2,1,2,3,2,4,2,5},
                    {3,3,1,1,2,2,4,4,5,5}};


            for(int i = 0 ; i < answers.length ; i++){
                for(int j = 0 ; j < students.length; j++){
                    if(check(answers[i], i, students[j])){
                        score[j+1] += 1;
                    }
                }
            }
            int maxScore = Arrays.stream(score).max().getAsInt();
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();
            for(int i = 1; i < score.length ; i++){
                if(score[i] == maxScore){
                    answerList.add(i);
                }
            }
            answer = answerList.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }

        public static boolean check(int answer, int quizNum, int[] student){
            if(student[(quizNum % student.length)] == answer){
                return true;
            }
            return false;
        }
    }
}
