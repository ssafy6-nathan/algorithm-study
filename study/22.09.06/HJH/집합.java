import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        n = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            switch (s) {
                case "all":
                    n = (1 << 21) - 1;

                    break;
                case "empty":
                    n = 0;

                    break;
                default:
                    int x = Integer.parseInt(st.nextToken());

                    switch (s) {
                        case "add":
                            n |= 1 << x;

                            break;
                        case "remove":
                            n &= ~(1 << x);

                            break;
                        case "check":
                            sb.append((n & (1 << x)) != 0 ? 1 : 0).append("\n");

                            break;
                        case "toggle":
                            n ^= 1 << x;

                            break;
                    }
            }
        }

        System.out.println(sb);

    }

}
