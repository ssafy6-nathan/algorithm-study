package week40;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1946번
 * 신입 사원 (https://www.acmicpc.net/problem/1946)
 * 분류 : 그디리 알고리즘, 정렬
 **/
public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N]; // 등수 저장
            int interviewRank = N; // 면접 등수 비교
            int count = 0; // 합격할 수 있는 최대 인원

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                // 서류 등수를 인덱스로 배열에 면접 점수를 저장 (서류 등수 기준으로 미리 오름차순 정렬됨)
                rank[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }

            // 한 개라도 높은 등수를 받았다면 합격이 가능함
            // 서류 등수대로 면접 등수를 확인하여 면접 등수가 더 높을 경우에만 카운트
            for (int k = 0; k < N; k++) {
                if(rank[k] <= interviewRank) {
                    count++;
                    interviewRank = rank[k];
                }
            }
            bw.write(count+"\n");
        }
        bw.close();
    }
}
