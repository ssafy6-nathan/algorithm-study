import java.io.*;

public class 동물원 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int mod = 9901;
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        dp[0] = 1; dp[1] = 3;
        for(int i = 2; i <= n; i++){
            dp[i] = ((dp[i-1] * 2) % mod + dp[i-2]) % mod;
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
