import java.util.*;

class Solution {
    
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0,1,0,-1};
    static int n,m;
    static int answer;

    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        
        //0은 벽, 1은 길
        //시작점 0,0 -> n-1,m-1
               
        Queue<Game> que = new LinkedList<>();
        
        que.add(new Game(0,0,1));
        //사방탐색 돌려서 맵안에 있는 곳이고, 0이며 방문하지 않았으면 큐에 넣기
        //마지막에 도달하면 그때까지의 CNT들 비교하기
        maps[0][0] = 0;
        
        while(!que.isEmpty()){
            Game g = que.poll();
            int r = g.r;
            int c = g.c;
            int cnt = g.cnt;
            
            if(r == n-1 && c == m-1){
                answer = cnt;
                break;
            }
            
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(!check(nr,nc))
                    continue;
                
                if(maps[nr][nc] != 1)
                    continue;
                
                maps[nr][nc] = 0;
                
                que.add(new Game(nr, nc, cnt+1));
            }
            
            
        }
        
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    
    public static boolean check(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;  
    }
}
class Game{
    int r;
    int c;
    int cnt;
    public Game(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
