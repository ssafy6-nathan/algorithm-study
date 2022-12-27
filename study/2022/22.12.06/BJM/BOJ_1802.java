package week39;

import java.io.*;

/**
 * 백준 1802번
 * 종이 접기 (https://www.acmicpc.net/problem/1802)
 * 분류 : 애드 혹, 분할 정복
 **/
public class BOJ_1802 {
    static int[] paper; // 접힌 정보 저장 배열
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int t = 0; t < T; t++) {
            flag = true; // flag 변수 초기화
            // 1. 종이가 접혀있는 정보 저장
            String str = br.readLine();
            if(str.length() == 1) { // 한 번 접은 경우는 무조건 가능
                bw.write("YES\n");
                continue;
            }
            paper = new int[str.length()];
            for (int i = 0; i < paper.length; i++)
                paper[i] = Character.getNumericValue(str.charAt(i));

            // 2. 분할정복
            check(0, paper.length / 2, paper.length-1);

            // 3. 결과값에 따라 출력
            if(flag) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.close();
    }

    private static void check(int start, int mid, int end) {
        if(mid == 0) return;
        int sp = start;
        int ep = end;
        for (int i = 0; i < mid; i++) {
            if(paper[sp++] == paper[ep--]) {
                flag = false;
                return;
            }
        }
        check(start, mid/2, mid-1);
    }
}
