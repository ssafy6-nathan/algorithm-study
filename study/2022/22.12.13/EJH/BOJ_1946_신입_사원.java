import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1946_신입_사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T, N;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                arr[A] = B;
            }

            int count = 1;
            int min_B = arr[1];
            for (int i = 2; i <= N; i++) {
                if (arr[i] < min_B) {
                    count += 1;
                }
                min_B = Math.min(min_B, arr[i]);
            }
            System.out.println(count);
        }
    }
}
