import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            int answer = 2;

            // 두 원이 겹칠 경우
            if (x1 == x2 && y1 == y2 && r1 == r2) answer = -1;
            // 두 원이 겹치지 않는 경우
            else if (distance > Math.pow(r1 + r2, 2)) answer = 0;
            // 두 원이 겹치면서 접점이 없을 경우
            else if (distance < Math.pow(r2 - r1, 2)) answer = 0;
            // 두 원이 내접할 경우
            else if (distance == Math.pow(r2 - r1, 2)) answer = 1;
            // 두 원이 외접할 경우
            else if (distance == Math.pow(r1 + r2, 2)) answer = 1;

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

}
