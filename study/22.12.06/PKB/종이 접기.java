import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int len = input.length();

            if (len == 1) {
                sb.append("YES").append("\n");

                continue;
            }

            int mid = len / 2;
            boolean flag = false;

            while (mid != 0) {
                for (int i = 0, j = len - 1; i < j; i++, j--) {
                    if (input.charAt(i) == input.charAt(j)) {
                        flag = true;

                        break;
                    }
                }

                if (flag) break;

                len /= 2;
                mid /= 2;
            }

            if (flag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }

        System.out.println(sb);

    }

}
