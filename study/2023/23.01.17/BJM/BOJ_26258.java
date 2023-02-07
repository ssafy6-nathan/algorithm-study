import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 26258번
 * 다중 일차 함수 (https://www.acmicpc.net/problem/26258)
 * 분류 : 수학, 이분 탐색, 두 포인터, 오프라인 쿼리
 **/
public class BOJ_26258 {
    static long[][] pt;
    static double k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 좌표 입력 후 저장
        int N = Integer.parseInt(br.readLine()); // 점의 개수
        pt = new long[N][2]; // 좌표 저장 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pt[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            pt[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }

        // 2. 쿼리 입력
        int Q = Integer.parseInt(br.readLine()); // 쿼리 개수
        for (int i = 0; i < Q; i++) {
            k = Double.parseDouble(br.readLine());
            int midIdx = search(k); // k와 인접한 x좌표 찾기
            bw.write(compare(midIdx) + "\n"); // y좌표 비교하여 기울기 계산
        }

        br.close();
        bw.close();
    }

    private static int search (double k) {
        int start = 0;
        int end = pt.length - 1;
        int mid;

        while (true) {
            mid = start + ((end - start) / 2);
            if (pt[mid][0] <= k && pt[mid+1][0] >= k) { // x = k 이거나 xmid ~ xmid+1 사이에 있을 때
                return mid;
            }
            else if (pt[mid][0] > k) { // k가 더 작을 경우 왼쪽 분기
                end = mid;
            }
            else { // k가 더 클 경우 오른쪽 분기
                start = mid;
            }
        }
    }

    private static int compare(int idx) {
        if (pt[idx][0] == k) { // (1) k가 midIdx의 x값과 같을 경우
            return (Long.compare(pt[idx + 1][1], pt[idx - 1][1]));
        } else { // (2) k가 midIdx의 x값보다 클 경우
            return (Long.compare(pt[idx + 1][1], pt[idx][1]));
        }
    }
}
