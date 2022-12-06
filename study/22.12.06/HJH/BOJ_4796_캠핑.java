import java.util.*;
import java.io.*;

public class BOJ_4796_캠핑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L, P, V;
        int tc = 1;
        int answer;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            if(L == 0) break;
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            answer = V / P * L + Math.min(L, V % P);
            System.out.printf("Case %d: %d\n", tc++, answer);
        }
        br.close();
    }
}