import java.util.*;

class Solution {
    static HashMap<Character, Integer> map;
    static String answer;
    public String solution(String[] survey, int[] choices) {
        answer = "";
        map = new HashMap<>();
        for(int i = 0; i < survey.length; i++){
            if(choices[i]-4 < 0)
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + Math.abs(choices[i]-4));
            else if(choices[i]-4 > 0)
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + Math.abs(choices[i]-4));
        }
        //첫번째 유형 검사
        if(map.containsKey('T')){
            int t = map.get('T');
            if(map.containsKey('R') && t > map.get('R'))
                answer = "T";
            else if(!map.containsKey('R'))
                answer = "T";
        }
        if(answer.length() != 1) answer = "R";
        
        //두번째 유형 검사
        if(map.containsKey('F')){
            int f = map.get('F');
            if(map.containsKey('C') && f > map.get('C'))
                answer += "F";
            else if(!map.containsKey('C'))
                answer += "F";
        }
        if(answer.length() != 2) answer += "C";
        
        //세번째 유형 검사
        if(map.containsKey('M')){
            int m = map.get('M');
            if(map.containsKey('J') && m > map.get('J'))
                answer += "M";
            else if(!map.containsKey('J'))
                answer += "M";
        }
        if(answer.length() != 3) answer += "J";
        
        //네번째 유형 검사
        if(map.containsKey('N')){
            int n = map.get('N');
            if(map.containsKey('A') && n > map.get('A'))
                answer += "N";
            else if(!map.containsKey('A'))
                answer += "N";
        }
        if(answer.length() != 4) answer += "A";
        
        return answer;
    }
}