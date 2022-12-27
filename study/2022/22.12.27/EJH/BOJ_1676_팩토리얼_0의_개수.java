import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_팩토리얼_0의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= N ; i++){
            int num = i;
            while (num % 5 == 0){
                count += 1;
                num /= 5;
            }
        }
        System.out.println(count);
    }
}
