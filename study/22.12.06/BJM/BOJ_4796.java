package week39;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 4796번
 * 캠핑 (https://www.acmicpc.net/problem/4796)
 * 분류 : 수학, 그리디 알고리즘
 **/
public class BOJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int L, P, V;
        int answer = 0;
        int count = 1; // Case count

        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) break;
            // V / P는 최대 L일을 사용할 수 있는 캠핑 횟수
            // V % P는 캠핑의 연속 P일을 다 채우지 못하는 남은 휴가일
            // 이때 V % P는 최대 L일 보다 클 수 있으므로 둘 중 더 작은 값을 더함
            answer = (L * (V / P)) + Math.min(V % P, L);
            bw.write("Case " + count++ + ": " + answer + "\n");
        }
        bw.close();
    }
}
