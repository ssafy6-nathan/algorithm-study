import java.io.*;
 
public class Solution {
    static long[][] record;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int R = 1_000_000_007;
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int N = str.length();
            record = new long[N][1 << 4];
 
            for (int day = 0; day < N; day++) {
                int turn = 1 << (str.charAt(day) - 'A');
 
                for (int sub = 0; sub < (1 << 4); sub++) {
                    if (day == 0) {
                        if ((sub & turn) > 0 && (sub & 1) > 0) {
                            record[0][sub] = 1;
                        }
                    } else {
                        if (record[day - 1][sub] == 0) continue;
                        for (int i = 0; i < (1 << 4); i++) {
                            if ((sub & i) > 0 && (turn & i) > 0) {
                                record[day][i] += record[day - 1][sub];
                                record[day][i] %= R;
                            }
                        }
                    }
                }
            }
            long answer = 0;
            for (int i = 0; i < (1 << 4); i++) {
                answer += record[N - 1][i];
                answer %= R;
            }
            bw.write("#" + t + " " + answer + "\n");
        }
        br.close();
        bw.flush();
    }
}
