import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 메모리: 19392 KB, 시간: 376 ms
public class Main {
    static int N;
    static int[][] map;
    static int[][] map2;
    // map 2개 필요해서 하나 copy 하거나 하나 더 생성

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
//        map2 = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
//        map2 = map.clone();
        // i -> j -> k = i -> k
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    if (map[i][j] == 1 && map[j][k] == 1) {
                        map[i][k] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
