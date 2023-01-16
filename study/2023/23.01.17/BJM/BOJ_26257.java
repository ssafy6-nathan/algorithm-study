import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 26257번
 * std::shared_ptr (https://www.acmicpc.net/problem/26257)
 * 분류 : 구현, 시뮬레이션
 **/
public class BOJ_26257 {
    static int[] pointer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 1. 포인터 배열 선언 (idx: 포인터 번호 / val: 객체 번호)
        pointer = new int[M];
        for (int i = 0; i < M; i++) {
            pointer[i] = Integer.parseInt(br.readLine());
        }

        // 2. 명령어 토큰 분리
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x, y;
            switch (cmd) {
                case "assign" :
                    x = Integer.parseInt(st.nextToken()) - 1;
                    y = Integer.parseInt(st.nextToken()) - 1;
                    assign(x, y);
                    break;
                case "swap" :
                    x = Integer.parseInt(st.nextToken()) - 1;
                    y = Integer.parseInt(st.nextToken()) - 1;
                    swap(x, y);
                    break;
                case "reset" :
                    x = Integer.parseInt(st.nextToken()) - 1;
                    reset(x);
                    break;
            }
        }

        // 3. 배열 오름차순 정렬 후 객체 개수 카운트
        Arrays.sort(pointer);
        int count = 0;
        for (int i = 0; i < pointer.length; i++) {
            if (pointer[i] == 0) continue;
            else if (pointer[i-1] == pointer[i]) continue;
            sb.append(pointer[i] + "\n");
            count++;
        }

        // 4. 출력
        System.out.println(count);
        System.out.println(sb.toString());

        br.close();
    }

    private static void assign (int x, int y) {
        pointer[x] = pointer[y];
    }
    private static void swap (int x, int y) {
        int temp = pointer[x];
        pointer[x] = pointer[y];
        pointer[y] = temp;
    }
    private static void reset (int x) {
        pointer[x] = 0;
    }

}
