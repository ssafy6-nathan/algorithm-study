import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs());

    }

    private static int bfs() {

        Queue<Long> q = new LinkedList<>();
        q.add(A);
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long a = q.poll();

                if (a == B) return cnt + 1;

                if (a * 2 <= B) q.add(a * 2);
                if (a * 10 + 1 <= B) q.add(a * 10 + 1);
            }

            cnt++;
        }

        return -1;

    }

}
