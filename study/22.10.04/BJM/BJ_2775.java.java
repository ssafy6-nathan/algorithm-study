import java.io.*;

/**
 * 백준 2775번
 * 부녀회장이 될테야 (https://www.acmicpc.net/problem/2775)
 * 분류 : 수학, 구현, 다이나믹 프로그래밍
 **/
public class BJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k, n = 0;
        int T = Integer.parseInt(br.readLine());

        // 아파트 2차원배열
        int[][] apart = new int[15][15];

        // 0층 채우기
        for (int i = 0; i < apart.length; i++)
            apart[0][i] = i;

        // 1 ~ 14층 채우기
        for (int i = 1; i < apart.length; i++) {
            for (int j = 1; j < apart[i].length; j++)
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
        }

        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            bw.write(apart[k][n]+"\n");
        }

        bw.flush();
        bw.close();
    }
}