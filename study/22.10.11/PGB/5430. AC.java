import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static String p;
    static Deque<Integer> deque;
    static boolean flag;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            deque = new ArrayDeque<>();
            flag = true;

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            AC();
        }

        System.out.println(sb);

    }

    private static void AC() {

        for (char c : p.toCharArray()) {
            if (c == 'R') {
                flag = !flag;
            } else if (c == 'D') {
                if (flag) {
                    if (deque.pollFirst() == null) {
                        sb.append("error").append("\n");

                        return;
                    }
                } else {
                    if (deque.pollLast() == null) {
                        sb.append("error").append("\n");

                        return;
                    }
                }
            }
        }

        print();

    }

    private static void print() {

        sb.append("[");

        if (deque.size() > 0) {
            if (flag) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");

    }

}
