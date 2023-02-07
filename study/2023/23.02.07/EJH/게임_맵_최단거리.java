import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited){
        int r = 0;
        int c = 0;
        visited[r][c] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cr = current[0];
            int cc = current[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr > maps.length-1 || nc < 0 || nc > maps[0].length-1)
                    continue;

                if(visited[nr][nc] == 0 && maps[nr][nc] == 1){
                    visited[nr][nc] = visited[cr][cc] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }

        }
    }
}
