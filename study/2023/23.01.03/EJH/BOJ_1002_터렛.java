import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1002_터렛 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());

        for(int t = 0; t < testCase ; t++){
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = arr[0];
            int y1 = arr[1];
            int r1 = arr[2];
            int x2 = arr[3];
            int y2 = arr[4];
            int r2 = arr[5];

            int result = 2;

            double length = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

            if(x1 == x2 && y1 == y2 && r1 == r2){
                result = -1;
            } else if ( length == Math.pow(r2 - r1, 2)){
                result = 1;
            } else if ( length == Math.pow(r2 + r1, 2)){
                result = 1;
            } else if (length < Math.pow(r2 - r1, 2)){
                result = 0;
            } else if (length > Math.pow(r2 + r1, 2)){
                result = 0;
            }

            System.out.println(result);

        }
    }
}
