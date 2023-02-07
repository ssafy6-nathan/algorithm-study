import java.io.*;

public class Main {
    static int[][] apt = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i <= 14; i++) {
                for (int j = 1; j <= 14; j++) {
                    if (i == 0) apt[i][j] = j;
                    else {
                        apt[i][j] = apt[i-1][j] + apt[i][j-1];
                    }
                }
            }
            sb.append(apt[k][n]).append('\n');
        }
        System.out.println(sb);
    }
}
