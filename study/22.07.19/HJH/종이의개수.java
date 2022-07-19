import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        br.close();
        bw.write(cnt[0] + "\n");
        bw.write(cnt[1] + "\n");
        bw.write(cnt[2] + "\n");
        bw.flush();

    }
    private static void divide(int r, int c, int N) {
        int size = N/3;
        if(check(r, c, N)){
            cnt[map[r][c]+1]++;
        } else {
            for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j++){
                    divide(r + size*i, c + size*j, size);
                }
            }
        }
    }
    private static boolean check(int r, int c, int N) {
        int color = map[r][c];
        for(int i = r; i < r + N; i++){
            for(int j = c; j < c + N; j ++){
                if(color != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
