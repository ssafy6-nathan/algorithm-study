class Solution {
    static int [] dr = {1,0,-1,0}; //아래 오른쪽 위 왼쪽
    static int [] dc = {0,1,0,-1};
    static int sr, sc, er, ec;
    static int temp;
    static int [][] map;
    static int[] answer;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        // queries.length 번 회전
        // rows, columns 만큼의 맵을 만들어서 숫자 먼저 넣어주기
        // 각 초기값들은 (i-1)*columns+j
        map = new int[rows+1][columns+1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = (i-1) * columns + j;
            }
        }//map에 각 숫자 넣기 완료
        
        answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            sr = queries[i][0];
            sc = queries[i][1];
            er = queries[i][2];
            ec = queries[i][3];
        //시작점 먼저 값 따로 저장
            temp = map[sr][sc];
            move(i, sr, sc, -1, temp);
            
        
        }
        
        return answer;
    }
    
    public static void move(int i, int r, int c, int d, int ans){
        //시작점에서 반시계방향으로 돌면서 칸에 있는 값 새로 바꾸기
        
        // r이 sr, er이고 c가 sc,ec 인 경우에만 방향 전환
        if((r == sr || r == er)&&(c == sc || c == ec))
            d++;
        
        int nr = r + dr[d];
        int nc = c + dc[d];
        
        map [r][c] = map[nr][nc];
        ans = Math.min(map[r][c], ans);
        
        if(nr == sr && nc == sc){
            map[r][c] = temp;
            answer[i] = ans;
            return;
        }
        
        move(i, nr, nc, d, ans);
                
    }
    
}