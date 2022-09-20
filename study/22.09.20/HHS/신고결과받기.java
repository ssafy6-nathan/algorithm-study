import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k){
        
        int len = id_list.length;
        boolean [][] rep = new boolean[len][len];
        
        int[] answer = new int[len];
        
        StringTokenizer token = null;
        
        for(int i = 0; i < report.length; i++){
            token = new StringTokenizer(report[i], " ");
            String start = token.nextToken();
            String end = token.nextToken();
            int s = 0, e = 0;
            for(int j = 0; j < len; j++){
                if(id_list[j].equals(start))
                    s = j;
                if(id_list[j].equals(end))
                    e = j;
            }
            rep[s][e] = true;
        }//신고 내역 true 처리완료
        
        for(int i = 0; i < len; i++){
            int count = 0;
            int people [] = new int[len];
            for(int j = 0; j < len; j++){
                if(rep[j][i]){
                    //신고 되어있는 유저의 카운트 올리고 해당 유저를 신고한 사람을 배열에 넣기
                    count++;
                    people[j] = 1;
                }
            }
            if(count >= k){//k번 이상 신고되었으면 해당 유저 신고한 사람들의 카운트 올리기
                for(int j = 0; j < len; j++){
                    if(people[j] == 1){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}