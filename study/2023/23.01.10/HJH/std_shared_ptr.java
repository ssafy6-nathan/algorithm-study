import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, Q;
    static boolean[] objects;
    static int[] pointers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        objects = new boolean[N + 1];
        pointers = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            pointers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            String calc = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (calc.equals("reset")) {
                pointers[x] = 0;
                continue;
            }

            int y = Integer.parseInt(st.nextToken());

            switch (calc) {
                case "assign":
                    pointers[x] = pointers[y];
                    break;
                case "swap":
                    int temp = pointers[x];
                    pointers[x] = pointers[y];
                    pointers[y] = temp;
                    break;
            }
        }

        int cnt = 0;

        for (int i = 1; i <= M; i++) {
            int p = pointers[i];

            if (objects[p]) continue;

            if (p > 0) {
                cnt++;
                objects[p] = true;
            }
        }

        sb.append(cnt).append("\n");

        for (int i = 1; i <= N; i++) {
            if (objects[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);

    }

}
