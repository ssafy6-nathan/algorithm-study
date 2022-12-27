import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        
        int M = grid.length;
        int N = grid[0].length();
        
        String map [][] = new String[M][N];
        
        for(int i = 0; i < M; i++){
            map[i] = grid[i].split("");
        }//map넣기 완료
        
        //각 좌표마다 각 방향에 따른 방문 여부보기
        boolean visited [][][] = new boolean[M][N][4];
        
        int dr [] = {1,0,-1,0}; //아래 왼 위 오른
        int dc [] = {0,-1,0,1};
        
        List<Integer> countList = new ArrayList<Integer>();
        
        //모든 방향에 따른 빛 다 넣어보기
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                for(int d = 0; d < 4; d++){
                    int r = i, c = j;
                    int cnt = 0;
                    //방문한 것 만나면 cnt 리스트에 넣기
                    while(!visited[r][c][d]){
                        visited[r][c][d] = true;
                        cnt++;
                        if(map[r][c].equals("R")){
                            d = (d+1) % 4;
                        }else if(map[r][c].equals("L")){
                            d = (d+3) % 4;
                        }
                        r = (r+dr[d]+M) % M;
                        c = (c+dc[d]+N) % N;
                    }
                    if(cnt > 0)
                        countList.add(cnt);
                }
            }
        }
        Collections.sort(countList);
        int answer [] = new int[countList.size()];
        for(int i = 0; i < countList.size(); i++){
            answer[i] = countList.get(i);
        }
        
        return answer;
    }
}