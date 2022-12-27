import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, team;
    static long min;
    static int[][] S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N / 2; i++) {
            team = 0;
            min = Integer.MAX_VALUE;

            combination(i, 1, 0);

            if (min == 0) break;
        }

        System.out.println(min);

    }

    private static void combination(int n, int cnt, int start) {

        if (cnt > n) {
            min = Math.min(min, calc());

            return;
        }

        for (int i = start; i < N; i++) {
            team |= 1 << i;

            combination(n, cnt + 1, i + 1);

            if (min == 0) return;

            team &= ~(1 << i);
        }

    }

    private static int calc() {

        int teamA = 0, teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((team & (1 << i)) > 0 && (team & (1 << j)) > 0) teamA += S[i][j] + S[j][i];
                else if ((team & (1 << i)) == 0 && (team & (1 << j)) == 0) teamB += S[i][j] + S[j][i];
            }
        }

        return Math.abs(teamA - teamB);

    }

}
