import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] chars;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        chars = br.readLine().toCharArray();

        for (int i = 0, len = chars.length; i < len;) {
            char c = chars[i];

            if (c == '<') {
                while (chars[i] != '>') i++;
                i++;
            } else if (c == ' ') i++;
            else {
                int start = i;
                while (i < len && chars[i] != '<' && chars[i] != ' ') i++;
                int end = i - 1;

                while (start < end) swap(start++, end--);
            }
        }

        for (char c : chars) sb.append(c);

        System.out.println(sb);

    }

    private static void swap(int a, int b) {

        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;

    }

}
