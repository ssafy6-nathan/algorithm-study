import java.util.*;
class Solution{

    static int answer;
    static int endIdx;
    
    public int solution(String s){
        
        endIdx = s.length();
        for(int i = 0; i < endIdx; i++){
            String substr = s.substring(i, endIdx);
            
            answer = Math.max(answer, palin(substr));
        }
        
        return answer+1;
    }
    public static int palin(String substr){
        int cnt = 0;
        
        for(int i = substr.length()-1; i >= 0; i--){
            if(check(0, i, substr)){
                cnt = i;
                break;
            }
        }
        
        return cnt;
    }
    public static boolean check(int start, int end, String str){
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}