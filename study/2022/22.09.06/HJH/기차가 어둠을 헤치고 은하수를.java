import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cmd, train, seat;
    static int[] arr;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());
            train = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    seat = Integer.parseInt(st.nextToken());

                    arr[train] |= 1 << seat;

                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken());

                    arr[train] &= ~(1 << seat);

                    break;
                case 3:
                    arr[train] <<= 1;
                    arr[train] &= (1 << 21) - 1;

                    break;
                case 4:
                    arr[train] >>= 1;
                    arr[train] &= ~1;

                    break;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());

    }

}
