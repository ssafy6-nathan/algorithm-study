import java.util.*;

class Solution {
    static int count;
    static boolean [] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 51;
        visited = new boolean[words.length];
        
        //target이 words에 없을 경우 0 리턴
        boolean exist = false;
        for(String str : words){
            if(str.equals(target)){
                exist = true;
            }
        }
        if(!exist)
            return 0;
        
        //begin단어와 한글자빼고 다 같으면 dfs로 시작하기
        for(int i = 0; i < words.length; i++){
            if(check(begin, words[i])){
                dfs(words, i, 1, target);
                answer = Math.min(count, answer);
            }
        }
        
        
        
        return answer;
    }
    
    private boolean check(String begin, String word){
        int cnt = 0;
        for(int i = 0; i < word.length(); i++){
            if(begin.charAt(i) != word.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        
        return false;
    }
    
    private void dfs(String [] words, int index, int cnt, String target){
        if(words[index].equals(target)){
            count = cnt;   
            return;
        }
        visited[index] = true;
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && check(words[index], words[i])){
                dfs(words, i, cnt+1, target);
            }
        }
    }
}