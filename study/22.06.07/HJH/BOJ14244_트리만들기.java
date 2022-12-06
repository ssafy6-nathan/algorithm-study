import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14244_트리만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M-1; i++){
            System.out.println(i + " " + (M-1));
        }
        for (int i = M - 1; i < N - 1; i++) {
            System.out.println(i + " " + (i + 1));
        }
    }
}
