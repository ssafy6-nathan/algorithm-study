import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, k, n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[15][15];

        for (int i = 0; i < 15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n]).append("\n");
        }

        System.out.println(sb);

    }

}
