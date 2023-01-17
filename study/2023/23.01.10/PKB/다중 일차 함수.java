import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int[][] points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            double k = Double.parseDouble(br.readLine());

            int x = binarySearch(k);

            int left = points[x - 1][1];
            int right = points[x][1];

            if (left < right) sb.append(1);
            else if (left > right) sb.append(-1);
            else sb.append(0);

            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static int binarySearch(double k) {

        int l = 0, r = N;

        while (l < r) {
            int m = (l + r) / 2;

            if (points[m][0] < k) l = m + 1;
            else r = m;
        }

        return l;

    }

}
