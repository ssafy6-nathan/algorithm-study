import java.util.*;
public class BOJ_2583 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int m, n, k;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[m][n];
        visited = new boolean[m][n];
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    int data = bfs(i, j);
                    list.add(data);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int cX = data[0];
            int cY = data[1];

            for(int i=0; i<4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX >=0 && nY >=0 && nX < m && nY < n) {
                    if(!visited[nX][nY] && map[nX][nY] == 0) {
                        visited[nX][nY] = true;
                        queue.offer(new int[]{nX, nY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
