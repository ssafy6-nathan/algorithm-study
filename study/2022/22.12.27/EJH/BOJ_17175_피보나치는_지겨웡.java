import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17175_피보나치는_지겨웡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        N = Integer.parseInt(br.readLine());

        long[] fibonacci = new long[N + 2];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2 ; i <= N ; i++){
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2] + 1) % 1000000007;
        }

        System.out.println(fibonacci[N]);
    }
}
