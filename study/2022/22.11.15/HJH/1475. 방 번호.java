import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[10];
        int ans = 1;
        int max = 1;
        if (N < 10) System.out.print(ans);
        else if (N == 1000000) System.out.print(6);
        else {
            while (N > 0) {
                num[N % 10]++;
                N = N / 10;
            }
            num[6] = (num[6] + num[9] + 1) / 2;
            for (int i = 0; i <= 8; i++) max = Math.max(max, num[i]);
            System.out.print(max);
        }
        br.close();
    }
}
