import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int m;
    static String input;
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            check = new int[128];
            m = Integer.parseInt(br.readLine());

            if (m == 0) break;

            input = br.readLine();
            int len = input.length() - 1;
            int start = -1, end = -1, cnt = 0, max = 0;

            while (end < len) {
                if (cnt < m || (cnt == m && check[input.charAt(end + 1)] > 0)) {
                    end++;
                    check[input.charAt(end)]++;

                    if (check[input.charAt(end)] == 1) cnt++;
                } else {
                    start++;
                    check[input.charAt(start)]--;

                    if (check[input.charAt(start)] == 0) cnt--;
                }

                max = Math.max(max, end - start);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);

    }

}
