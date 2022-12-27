import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            if (A[0] <= M) System.out.println(A[0]);
            else System.out.println(0);

            return;
        }

        int start = 0, end = 1, sum = 0, max = 0;

        if (A[start] <= M) sum += A[start];

        while (start <= end && end < N) {
            if (sum + A[end] <= M) {
                sum += A[end];
                end++;
            } else {
                if (A[end] > M && end + 1 < N) {
                    sum = 0;
                    start = end + 1;
                    end++;
                } else {
                    sum -= A[start];
                    start++;
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

}
