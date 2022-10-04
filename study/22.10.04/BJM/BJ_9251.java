package week30;
import java.io.*;

/**
 * 백준 9251번
 * LCS (https://www.acmicpc.net/problem/9251)
 * 분류 : 다이나믹 프로그래밍, 문자열
 **/

public class BJ_9251 {

    // 두 문자열을 저장할 문자 배열
    static char[] stringA = new char[1001];
    static char[] stringB = new char[1001];

    // LCS 2차원 배열
    static int[][] LCS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 A와 문자열 B를 입력받음
        String a = br.readLine();
        String b = br.readLine();

        // 문자 배열에 알파벳 하나씩 저장
        for (int i = 0; i < a.length(); i++)
            stringA[i+1] = a.charAt(i);
        for (int i = 0; i < b.length(); i++)
            stringB[i+1] = b.charAt(i);

        // 문자열 길이 만큼 LCS 배열 생성 
        LCS = new int[a.length() + 1][b.length() + 1];

        // LCS 배열 채우기
        for (int i = 0; i < LCS.length; i++) {
            for (int j = 0; j < LCS[i].length; j++) {

                // 배열 마진값 설정
                if (i == 0 | j == 0) {
                    LCS[i][j] = 0;
                    continue;
                }
                // 1. 비교하는 문자가 같은 경우 값 1을 누적
                if (stringA[i] == stringB[j])
                    LCS[i][j] = LCS[i-1][j-1] + 1;

                // 2. 비교하는 문자가 같지 않은 경우 지금까지의 LCS값 유지
                else
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
        }

        // 최종적으로 도출된 최장공통부분수열의 가장 긴 값을 출력
        bw.write(LCS[a.length()][b.length()] + "");
        bw.flush();
        bw.close();
    }
}