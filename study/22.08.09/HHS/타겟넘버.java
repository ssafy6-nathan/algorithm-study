import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[] nums;
    static int tarNum;
    
    public int solution(int[] numbers, int target) throws IOException{
        nums = new int[numbers.length];
        for(int i=0; i < numbers.length; i++){
            nums[i] = numbers[i];
        }
        tarNum = target;
        dfs(0,0);        
        
        return answer;
    }
    public static void dfs(int num, int sum){
        if(num == nums.length && sum == tarNum){
            answer++;
        }else if(num < nums.length){
            dfs(num+1, sum+nums[num]);
            dfs(num+1, sum-nums[num]);
        }
    }
    
}