import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;
    static int[] alpha;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
        int len = s.length();
        alpha = new int[26];

        for (int i = 0; i < len; i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        int odd = 0, center = 0;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                odd++;
                center = i;
            }
        }

        if (odd > 1 || (odd == 1 && len % 2 == 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String result = sb.toString();
        if (odd == 1) result += (char) (center + 'A');
        result += sb.reverse().toString();

        System.out.println(result);

    }

}
