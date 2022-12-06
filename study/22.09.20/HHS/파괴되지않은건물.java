import java.util.*;

class Solution {
    
    static int answer;
    static int R, C;
    static int [][] cal;
    
    public int solution(int[][] board, int[][] skill) {
        R = board.length;
        C = board[0].length;
        cal = new int[R+1][C+1];
        
        for(int t = 0; t < skill.length; t++){
            int r1 = skill[t][1];
            int c1 = skill[t][2];
            int r2 = skill[t][3];
            int c2 = skill[t][4];
            int d = skill[t][5];
            if(skill[t][0] == 1) //적군
                d = -d;
            
            cal[r1][c1] += d;
            cal[r2+1][c2+1] += d;
            cal[r2+1][c1] -= d;
            cal[r1][c2+1] -= d;
        }
        
        for(int i = 1; i < R; i++){
            for(int j = 0; j < C; j++){
                cal[i][j] += cal[i-1][j];
            }
        }
        for(int j = 1; j < C; j++){
            for(int i = 0; i < R; i++){
                cal[i][j] += cal[i][j-1];
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(board[i][j] + cal[i][j] > 0)
                    answer++;
            }
        }
        
        return answer;
    }
}