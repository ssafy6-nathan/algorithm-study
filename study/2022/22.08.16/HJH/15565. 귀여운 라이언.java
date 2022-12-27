import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, sum = 0, len, ans = INF;
        boolean lflag = false, rflag = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                l = i;
                r = i;
                break;
            }
        }
        while (r < N && l < N) {
            if (rflag && arr[r] == 1) {
                sum++;
                if (sum == K) {
                    rflag = false;
                    lflag = true;
                    sum--;
                    len = r - l + 1;
                    ans = Math.min(len, ans);
                }
            } else if (lflag && arr[l] == 1) {
                lflag = false;
                rflag = true;
            }
            if (lflag) {
                l++;
            } else
                r++;
        }
        if (ans == INF)
            bw.write("-1" + "\n");
        else
            bw.write(ans + "\n");
        br.close();
        bw.flush();

    }
}
