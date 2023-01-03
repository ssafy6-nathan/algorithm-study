import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (X > 0) {
            cnt += X % 2;
            X /= 2;
        }

        System.out.println(cnt);

    }

}
