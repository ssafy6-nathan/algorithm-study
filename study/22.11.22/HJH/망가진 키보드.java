import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int M = Integer.parseInt(br.readLine());
            if (M == 0) break;
            String str = br.readLine();
            int[] check = new int[128];
            int s = -1, e = -1, cnt = 0, max = 0;
            while (s <= e) {
                if (cnt < M) {
                    e++;
                    check[str.charAt(e)]++;
                    if (check[str.charAt(e)] == 1) cnt++;
                } else if (cnt == M && check[str.charAt(e + 1)] > 0) {
                    e++;
                    check[str.charAt(e)]++;
                } else {
                    s++;
                    check[str.charAt(s)]--;
                    if (check[str.charAt(s)] == 0) cnt--;
                }
                max = Math.max(e - s, max);
                if (e == str.length() - 1) break;
            }
            System.out.println(max);
        }
    }
}
