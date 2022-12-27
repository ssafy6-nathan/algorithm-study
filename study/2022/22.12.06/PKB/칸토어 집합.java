import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while ((input = br.readLine()) != null && input.length() != 0) {
            N = Integer.parseInt(input);
            int len = (int) Math.pow(3, N);
            sb = new StringBuilder();

            for (int i = 0; i < len; i++) {
                sb.append(" ");
            }

            make(0, len);

            answer.append(sb).append("\n");
        }

        System.out.print(answer);

    }

    private static void make(int start, int len) {

        if (len == 1) {
            sb.setCharAt(start, '-');

            return;
        }

        int newLen = len / 3;

        make(start, newLen);
        make(start + 2 * newLen, newLen);

    }

}
