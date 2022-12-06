import java.util.*;

class Solution {
    
    static int diff; //어피치와의 차이
    static int [] answer = {-1};
    static int N;
    static int [] apeach;
    
    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info;
        
        dfs(0, new int [info.length]);
        
        return answer;
    }
    private static void dfs(int count, int [] ryan){
        if(count == N){
            int R = 0;
            int A = 0;
            for(int i = 0; i < apeach.length; i++){
                if(ryan[i] > apeach[i])
                    R += 10-i;
                else if(apeach[i] > 0 && apeach[i] >= ryan[i])
                    A += 10-i;
            }
            if(R > A){
                diff = Math.max(R-A, diff);
                if(diff == R-A)
                    answer = ryan.clone();
            }
            return;
        }

        for(int i = 0; i < apeach.length; i++){
            if(ryan[i] > apeach[i]) break;
            
            ryan[i]++;
            dfs(count+1, ryan);
            ryan[i]--;
            
        }
        
    }
}