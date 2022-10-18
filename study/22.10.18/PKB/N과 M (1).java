import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0, 0);

        System.out.println(sb);

    }

    private static void dfs(int cnt, int flag) {

        if (cnt == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((flag & (1 << i)) > 0) continue;

            arr[cnt] = i;

            dfs(cnt + 1, flag | (1 << i));
        }

    }

}
