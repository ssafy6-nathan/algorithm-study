import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    static String s;
    static char[] stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (!Objects.equals(s = br.readLine(), ".")) {
            sb.append(check()).append("\n");
        }

        System.out.println(sb);

    }

    private static String check() {

        stack = new char[s.length()];
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack[idx++] = c;
            } else if (c == ')') {
                if (idx == 0 || stack[idx - 1] != '(') return "no";
                else idx--;
            } else if (c == ']') {
                if (idx == 0 || stack[idx - 1] != '[') return "no";
                else idx--;
            }
        }

        if (idx != 0) return "no";
        else return "yes";

    }

}
