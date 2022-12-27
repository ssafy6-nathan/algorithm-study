package boj;

import java.io.*;

public class BOJ_1802_종이접기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine();
            int s = 0, e = str.length() - 1;
            boolean check = true;
            while (s < e) {
                int left = s;
                int right = e;
                while (left < right) {
                    if (str.charAt(left) == str.charAt(right)) {
                        check = false;
                        break;
                    }
                    left++;
                    right--;
                }
                e = right - 1;
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}

