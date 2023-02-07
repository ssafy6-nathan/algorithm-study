import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1591 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long N = arr[0];
        long M = arr[1];

        int[] rides = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (N <= M){
            System.out.println(N);
            return;
        }
        long start = 0;
        long end = N * 30;

        while (start <= end){
            long mid = (start + end) / 2;

            long children = canRideChildren(rides, mid);

            if (children < N){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        long checkChildren = canRideChildren(rides, end);

        int lastRide = -1;
        for (int i = 0; i < rides.length ; i++){
            if ((end + 1) % rides[i] == 0){
                if (++checkChildren == N){
                    lastRide = i + 1;
                    break;
                }
            }
        }
        System.out.println(lastRide);
    }

    public static long canRideChildren(int[] rides, long time){
        long children = 0;

        for (int i = 0; i < rides.length ; i++){
            children += time / rides[i] + 1;
        }
        return children;
    }
}
