import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] isVisted;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int year = 0;

        while(true){
            isVisted = new boolean[N][M];
            int cnt = 0;
            boolean flag = false;

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(map[i][j] != 0 && !isVisted[i][j]){
                        cnt++;
                        if(cnt == 2){
                            flag = true;
                            break;
                        }
                        cntIceBerg(i, j);
                    }
                }
            }
            if(flag)
                break;

            if(cnt == 0){
                year = 0;
                break;
            }

            meltIce();
            year++;
        }

        System.out.println(year);
    }
    private static void meltIce() {
        int[][] copyMap = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            copyMap[i] = Arrays.copyOf(map[i], M);
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(copyMap[i][j] != 0){
                    int zeroCnt = 0;

                    for(int d = 0 ; d < 4; d++){
                        int nx = i + dr[d];
                        int ny = j + dc[d];

                        if(nx < 0 || N <= nx || ny < 0 || M <= ny)
                            continue;

                        if(copyMap[nx][ny] == 0)
                            zeroCnt++;
                    }

                    map[i][j] = Math.max(0, copyMap[i][j] - zeroCnt);
                }
            }
        }
    }
    private static void cntIceBerg(int x, int y) {
        Queue<node> queue = new LinkedList<>();
        isVisted[x][y] = true;
        queue.offer(new node(x, y));

        while(!queue.isEmpty()){
            node now = queue.poll();

            for(int i = 0 ; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];

                if(nx < 0 || N <= nx || ny < 0 || M <= ny)
                    continue;

                if(map[nx][ny] != 0 && !isVisted[nx][ny]){
                    queue.offer(new node(nx, ny));
                    isVisted[nx][ny] = true;
                }
            }
        }
    }
}
