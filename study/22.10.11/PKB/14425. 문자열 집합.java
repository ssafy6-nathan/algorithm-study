import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) cnt++;
        }

        System.out.println(cnt);

    }

}
