import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static String s;
    static int[] alpha;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        alpha = new int[26];

        for (int i = 0; i < N; i++) {
            s = br.readLine();

            for (int j = 0, len = s.length(); j < len; j++) {
                alpha[s.charAt(j) - 'A'] += Math.pow(10, len - j - 1);
            }
        }

        Arrays.sort(alpha);

        int sum = 0;

        for (int i = 25; i >= 17; i--) {
            sum += alpha[i] * (i - 16);
        }

        System.out.println(sum);

    }

}
