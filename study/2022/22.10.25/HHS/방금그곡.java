import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;
        String mu = "";
        for(int i = 0; i < m.length(); i++){
            if(i+1 < m.length() && m.charAt(i) != '#' && m.charAt(i+1) == '#'){
                mu += m.substring(i, i+1).toLowerCase();
                i++;
            }       
            else
                mu += m.charAt(i);
        }

        for(int i = 0; i < musicinfos.length; i++){
            StringTokenizer token = new StringTokenizer(musicinfos[i], ",:");
            int start = Integer.parseInt(token.nextToken())*60 + Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken())*60 + Integer.parseInt(token.nextToken());
            int time = end-start; //재생시간
            
            String title = token.nextToken(); //곡 제목
            String tempMusic = token.nextToken(); //곡 음계
            String music = "";
            for(int s = 0; s < tempMusic.length(); s++){
                if(s+1 < tempMusic.length() && tempMusic.charAt(s) != '#' && tempMusic.charAt(s+1) == '#'){
                    music += tempMusic.substring(s, s+1).toLowerCase();
                    s++;
                }
                else
                    music += tempMusic.charAt(s);
            }
            String temp = "";
            for(int j = 0; j < time; j++){
                temp += music.charAt(j % music.length());
            }
            if(temp.contains(mu)){
                if(len < time){
                    len = time;
                    answer = title;
                } 
            }
        }
        return answer;
    }
}
