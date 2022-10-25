import java.util.*;

class Solution {
    static HashSet<String> ans;
    static int N;
    static int R;
    static String [] user;
    static String [] banned;
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        R = banned_id.length;
        user = user_id;
        banned = banned_id;
        
        ans = new HashSet<>();
        Permutation(0,new String[R], new boolean[N]);    

        return ans.size();
    }
    private static void Permutation(int cnt, String [] ids, boolean [] visited){
        if(cnt == R){
            HashSet<String> tp = new HashSet<>();
            for(int i = 0; i < cnt; i++){
                tp.add(ids[i]);
            }
            if(tp.size() == R){
                String [] temp = new String[R];
                
                for(int num = 0; num < R; num++)
                    temp[num] = ids[num];
                
                Arrays.sort(temp);
                String a = "";
                for(int s = 0; s < R; s++)
                    a += temp[s];
                ans.add(a);
            }
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            if(user[i].length() != banned[cnt].length()) continue;
            boolean check = true;
            for(int u = 0; u < user[i].length(); u++){
                if(banned[cnt].charAt(u) == '*') continue;
                if(user[i].charAt(u) != banned[cnt].charAt(u)){
                    check = false;
                    break;
                }    
            }
            if(check){
                visited[i] = true;
                ids[cnt] = user[i];
                Permutation(cnt+1, ids, visited);
                visited[i] = false;
            }
        }
    }
}