import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.length() < M) continue;

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> {
            int c = map.get(o2) - map.get(o1);

            if (c == 0) {
                int l = o2.length() - o1.length();

                if (l == 0) return o1.compareTo(o2);

                return l;
            }

            return c;
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }

}
