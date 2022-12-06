package week37;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken()); // 구멍개수
        M = Integer.parseInt(st.nextToken()); // 최대크기
        int[] holes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            holes[i] = Integer.parseInt(st.nextToken());

        int start = 0; // 좌포인터
        int end = 0; // 우포인터
        int answer = 0; // 최종 정답
        int vol = 0; // 현재 부피

        // 배열 내에서 포인터 두 개를 움직이며 부피 계산
        while (end <= N - 1) {
            // (1) 최대 크기보다 커지면 좌측 포인터를 한 칸 옮기면서 크기 조정
            if (vol > M) {
                vol -= holes[start++];
            }
            // (2) 최대 크기를 초과하지 않았거나, 포인터의 위치가 같아지면 우측 포인터를 한 칸 옮기고 크기 조정
            else if (start == end || vol <= M) {
                vol += holes[end++];
            }
            // (3) 부피가 최대 크기를 넘지 않는 선에서 현재 최대 부피 값이면 정답 갱신
            if (vol > answer && vol <= M) answer = vol;
        }
        System.out.println(answer);
    }
}
