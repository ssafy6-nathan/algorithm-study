class Solution {
    
    static int answer;
    static boolean [] visited;
    static int N;
    
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];

        //방문하지 않았던 컴퓨터면 answer올리고 dfs 돌리기
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, answer, computers);
            }
        }
        
        return answer;
    }
    private void dfs(int s, int ans, int [][] map){
        //하나씩 다 돌면서 노선이 연결되어있고 방문하지 않은 컴퓨터가 있으면 dfs 넣기
        for(int i = 0; i < N; i++){
            if(map[i][s] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, ans, map);            
            }
        }
        
    }
}
