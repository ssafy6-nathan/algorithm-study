import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1629_곱셈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long A = arr[0];
        long B = arr[1];
        long C = arr[2];


        System.out.println(modCal(A, B, C));

    }

    public static long modCal( long A, long B, long C){
        if(B == 1){
            return A % C;
        }
        long mod = modCal( A, B / 2, C);

        if (B % 2 == 1){
            return (mod * mod % C) * A % C;
        }
        return mod * mod % C;
    }
}
