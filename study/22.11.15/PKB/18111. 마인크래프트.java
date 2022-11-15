import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, B, minH, maxH, minTime, height;
    static int[] heights;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        heights = new int[257];
        minH = 256;
        maxH = 0;
        minTime = Integer.MAX_VALUE;
        height = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());

                heights[h]++;
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
            }
        }

        for (int h = minH; h <= maxH; h++) {
            int block = B;
            int time = 0;

            for (int i = 0; i <= 256; i++) {
                if (heights[i] == 0 || h == i) continue;

                int diff = Math.abs(h - i) * heights[i];

                if (h < i) {
                    time += 2 * diff;
                    block += diff;
                } else {
                    time += diff;
                    block -= diff;
                }
            }

            if (block < 0) continue;

            if (minTime >= time) {
                minTime = time;
                height = h;
            }
        }

        System.out.println(minTime + " " + height);

    }

}
