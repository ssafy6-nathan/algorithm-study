import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        moo(n);

        System.out.println(ans);
    }

    public static void moo(int num) {
        int side = 3;
        int center = 0;

        while(num > side) {
            // 4를 더하는 이유는 두번째 수열을 더하기 위함
            side = center + 4 + side * 2;
            center++;
        }

        // 3을 빼주는 이유는 while문에서 center는 1씩 증가해서
        // center+4가 실제 가운데 영역보다 1크기 때문에
        int fb = (side - center - 3) / 2;

        if(side - fb+1 <= num) {
            moo(num - side+fb);
        }else if(num == fb+1) {
            ans = "m";
        }else {
            ans = "o";
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        // S(k) = S(k-1) + (o * (k+2)) + S(k-1) 대칭?
//        // S(0) = moo
//        // S(1) = moo + m o*3
//        // 0 // 2
//        // 1 // 2 3 2
//        // 2 // 2 3 2 4 2 3 2
//        // 3 // 2 3 2 4 2 3 2 5 2 3 2 4 2 3 2
//        //  // s(k-1) o2 +
//        // k+1 // k + (k+3) + k
//        // 11
//        br.close();
//
//    }

}
