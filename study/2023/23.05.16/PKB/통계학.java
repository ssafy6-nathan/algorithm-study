import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[8001];
        int sum = 0;
        int mid = Integer.MAX_VALUE;
        int mode = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            sum += n;
            arr[n + 4000]++;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int cnt = 0;
        int modeMax = 0;
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            int n = arr[i];

            if (n > 0) {
                if (cnt < (N + 1) / 2) {
                    cnt += n;
                    mid = i - 4000;
                }

                if (modeMax < n) {
                    modeMax = n;
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == n && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        sb.append(Math.round(sum / (double) N)).append("\n")
                .append(mid).append("\n")
                .append(mode).append("\n")
                .append(max - min).append("\n");

        System.out.println(sb);

    }

}
