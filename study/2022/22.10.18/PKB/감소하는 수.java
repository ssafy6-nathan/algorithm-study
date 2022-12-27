import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                decrease(i);
            }

            Collections.sort(list);

            System.out.println(list.get(N));
        }

    }

    private static void decrease(long n) {

        list.add(n);

        for (int i = 0, len = (int) (n % 10); i < len; i++) {
            decrease((n * 10) + i);
        }

    }

}
