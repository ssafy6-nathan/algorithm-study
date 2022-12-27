import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static List<Integer>[] list;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        list = new ArrayList[N * N + 1];

        for (int i = 0, len = N * N; i < len; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            list[n] = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                int m = Integer.parseInt(st.nextToken());
                list[n].add(m);
            }

            check(n);
        }

        System.out.println(calc());

    }

    private static void check(int n) {

        int maxFavorite = -1;
        int maxBlank = -1;
        int x = 0;
        int y = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int favorite = 0;
                int blank = 0;

                if (map[r][c] != 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;

                    if (map[nr][nc] > 0 && list[n].contains(map[nr][nc])) favorite++;
                    else if (map[nr][nc] == 0) blank++;
                }

                if (maxFavorite < favorite) {
                    maxFavorite = favorite;
                    maxBlank = blank;
                    x = r;
                    y = c;
                } else if (maxFavorite == favorite && maxBlank < blank) {
                    maxBlank = blank;
                    x = r;
                    y = c;
                }
            }
        }

        map[x][y] = n;

    }

    private static int calc() {

        int sum = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int n = map[r][c];
                int favorite = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;

                    if (list[n].contains(map[nr][nc])) favorite++;
                }

                if (favorite == 1) sum += 1;
                else if (favorite == 2) sum += 10;
                else if (favorite == 3) sum += 100;
                else if (favorite == 4) sum += 1000;
            }
        }

        return sum;

    }

}
