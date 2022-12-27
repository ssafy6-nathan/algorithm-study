import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = n; j > 1; j /= 2) {
                if (visit[j]) answer = j;
            }

            visit[n] = true;

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

}
