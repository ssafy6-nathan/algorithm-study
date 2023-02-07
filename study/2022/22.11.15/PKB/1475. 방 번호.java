import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[10];
        cnt = 1;

        if (N < 10) {
            System.out.println(1);

            return;
        }

        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;

            cnt = Math.max(cnt, arr[i]);
        }

        cnt = Math.max(cnt, (arr[6] + arr[9] + 1) / 2);

        System.out.println(cnt);

    }

}
