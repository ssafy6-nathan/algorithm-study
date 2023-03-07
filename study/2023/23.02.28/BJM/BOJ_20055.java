package week48;

import java.io.*;
import java.util.*;

/**
 * 백준 20055번
 * 컨베이어 벨트 위의 로봇 (https://www.acmicpc.net/problem/20055)
 * 분류 : 구현, 시뮬레이션
 **/
public class BOJ_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ===== 입력 =====
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 칸 개수
        int K = Integer.parseInt(st.nextToken()); // 내구도 0인 칸 개수 제한

        int[] conveyor = new int[2 * N]; // 컨베이어 벨트의 내구도 저장
        boolean[] robots = new boolean[N]; // 벨트 위 로봇 존재 여부 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < conveyor.length; i++)
            conveyor[i] = Integer.parseInt(st.nextToken());
        // ===============

        int onIdx = 0; // 올리는 위치
        int offIdx = N - 1; // 내리는 위치
        int turnCnt = 0; // 로테이션 횟수
        int countK = 0; // 비활성화된 칸 개수

        while (countK < K) {
            turnCnt++; // 로테이션 횟수 갱신
            countK = 0;

            // 1. 벨트 회전
            if (onIdx == 0) {
                onIdx = (2 * N) - 1;
                offIdx--;
            } else if (offIdx == 0) {
                offIdx = (2 * N) - 1;
                onIdx--;
            } else {
                onIdx--;
                offIdx--;
            }

            robots[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
                robots[i - 1] = false;
            }

            // 2. 로봇 이동
            if (robots[N - 1]) robots[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {
                // 해당 칸에 로봇이 있을 때, 이동하려는 칸에 로봇이 없고 내구도가 1 이상이어야함
                if (robots[i - 1] && !robots[i] && conveyor[(onIdx + i) % (2 * N)] > 0) {
                    robots[i] = robots[i - 1];
                    robots[i - 1] = false;
                    conveyor[(onIdx + i) % (2 * N)]--;
                }
            }

            // 3. 로봇 올리기
            if (conveyor[onIdx] > 0) {
                robots[0] = true;
                conveyor[onIdx]--;
            }

            // 4. 내구도가 0인 칸이 K개가 되었는지 확인
            for (int i : conveyor) if (i == 0) countK++;
        }

        System.out.println(turnCnt);
    }
}
