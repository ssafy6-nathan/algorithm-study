package week39;

import java.io.*;

/**
 * 백준 4779번
 * 칸토어 집합 (https://www.acmicpc.net/problem/4779)
 * 분류 : 분할 정복, 재귀
 **/
public class BOJ_4779 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while((input = br.readLine()) != null && !input.equals("")) {
            int n = Integer.parseInt(input);
            if (n == 0) {
                bw.write("-\n");
                continue;
            }
            sb = new StringBuilder();
            for (int i = 0; i < Math.pow(3, n); i++) {
                sb.append(" ");
            }

            recur(0, sb.length());
            bw.write(sb.toString()+"\n");
        }
        bw.close();
    }

    private static void recur (int start, int len) {
        if (len == 3) {
            sb.setCharAt(start, '-');
            sb.setCharAt(start + 2, '-');
            return;
        }
        recur(start, len / 3);
        recur(start + 2 * (len / 3), len / 3);
    }
}

