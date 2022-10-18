import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int cnt) {

        if (cnt == N * M) {
            count++;
            return;
        }

        int r = cnt / M + 1;
        int c = cnt % M + 1;

        if (map[r][c - 1] == 1 && map[r - 1][c] == 1 && map[r - 1][c - 1] == 1) {
            dfs(cnt + 1);
        } else {
            map[r][c] = 1;
            dfs(cnt + 1);
            map[r][c] = 0;
            dfs(cnt + 1);
        }
    }
}
