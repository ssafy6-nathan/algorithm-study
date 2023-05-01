import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int switchN, studentN;
    static int[] switches;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        switchN = Integer.parseInt(br.readLine());
        switches = new int[switchN + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= switchN; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        studentN = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int j = num; j <= switchN; j += num) {
                    switches[j] ^= 1;
                }
            } else {
                int l = num - 1;
                int r = num + 1;

                while (l > 0 && r <= switchN && switches[l] == switches[r]) {
                    l--;
                    r++;
                }

                for (int j = l + 1; j < r; j++) {
                    switches[j] ^= 1;
                }
            }
        }

        for (int i = 1; i <= switchN; i++) {
            sb.append(switches[i]).append(" ");

            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);

    }

}
