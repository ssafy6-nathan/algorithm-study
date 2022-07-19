import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17074 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int idx = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                cnt++;
                idx = i;
            }
            if (cnt == 2) {
                System.out.println("0");
                return;
            }
        }
        if (cnt == 0) {
            System.out.println(n);
            return;
        }
        if (idx == 0) {
            ans++;
        } else {
            if (arr[idx - 1] <= arr[idx + 1]) ans++;
        }
        if (idx == n - 2) {
            ans++;
        } else {
            if (arr[idx] <= arr[idx + 2]) ans++;
        }
        System.out.println(ans);
    }
}
