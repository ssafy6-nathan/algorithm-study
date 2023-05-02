package week54;

import java.io.*;
import java.util.*;

/**
 * 백준 1244번
 * 스위치 켜고 끄기 (https://www.acmicpc.net/problem/1244)
 * 분류 : 구현, 시뮬레이션
 **/
public class BOJ_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 스위치 저장
        int lightNum = Integer.parseInt(br.readLine()); // 스위치 개수
        boolean[] light = new boolean[lightNum + 1]; // 스위치 상태 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= lightNum; i++) {
            int switchState = Integer.parseInt(st.nextToken());
            if (switchState == 0) light[i] = false;
            else light[i] = true;
        }

        // 2. 학생 정보 저장
        int studentNum = Integer.parseInt(br.readLine()); // 학생 수
        int[][] studentInfo = new int[studentNum][2]; // 학생 정보 저장
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            studentInfo[i][0] = Integer.parseInt(st.nextToken()); // 성별 저장
            studentInfo[i][1] = Integer.parseInt(st.nextToken()); // 학생이 받은 수
        }

        // 3. 규칙에 따른 스위치 on/off 실행
        for (int n = 0; n < studentInfo.length; n++) {
            int gender = studentInfo[n][0]; // 성별
            int number = studentInfo[n][1]; // 받은 수

            if (gender == 1) { // 남학생일 경우
                int count = number; // 현재 스위치 번호
                int times = 1; // 배수
                while (number * times < light.length) {
                    count = number * times;
                    light[count] = !light[count]; // 배수 칸의 스위치 전환
                    times++;
                }
            } else { // 여학생일 경우
                int start = number;
                int end = number;
                while (start - 1 > 0 && end + 1 < light.length && light[start - 1] == light[end + 1]) {
                    start--;
                    end++;
                }
                for (int i = start; i <= end; i++)
                    light[i] = !light[i];
            }
        }

        // 4. 스위치 상태 출력
        for (int i = 1; i < light.length; i++) {
            if (light[i]) bw.write("1 ");
            else bw.write("0 ");
            if (i % 20 == 0) bw.newLine();
        }
        bw.close();
    }
}