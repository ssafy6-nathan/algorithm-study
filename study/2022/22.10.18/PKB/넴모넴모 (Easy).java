import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, size, cnt;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        size = N * M;
        cnt = 0;

        dfs(0);

        System.out.println(cnt);

    }

    private static void dfs(int n) {

        if (n == size) {
            cnt++;

            return;
        }

        int r = n / M + 1;
        int c = n % M + 1;

        if (map[r][c - 1] && map[r - 1][c - 1] && map[r - 1][c]) dfs(n + 1);
        else {
            map[r][c] = true;
            dfs(n + 1);

            map[r][c] = false;
            dfs(n + 1);
        }

    }

}
