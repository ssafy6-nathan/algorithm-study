package boj;

import java.io.*;

public class BOJ_4779_칸토어집합 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String str;
        while ((str = br.readLine()) != null) {
            sb = new StringBuilder();
            N = Integer.parseInt(str);
            if (N == 0) sb.append("-");
            else paste(N);
            System.out.println(sb);
        }
    }

    public static void paste(int n) {
        if (n == 0) {
            sb.append("-");
            return;
        } else {
            paste(n - 1);
            int i = 0;
        int r = (int) Math.pow(3, n - 1);
            while (i < r) {
                sb.append(' ');
                i++;
            }
            paste(n - 1);
        }

    }
}