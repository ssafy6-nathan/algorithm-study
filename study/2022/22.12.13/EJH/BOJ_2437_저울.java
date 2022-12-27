import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437_저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             int num = Integer.parseInt(st.nextToken());
             arr[i] = num;
        }
        Arrays.sort(arr);
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > sum + 1) break;
            sum += arr[i];
        }
        System.out.println(sum + 1);
    }
}