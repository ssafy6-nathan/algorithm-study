import java.util.Arrays;
import java.util.Scanner;

public class BOJ_26258_다중_일차_함수 {
    static int N, Q;
    static int[] arr,x ,y;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        x = new int[N + 1];
        y = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x[i] = arr[0];
            y[i] = arr[1];
        }

        sb = new StringBuilder();

        Q = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= Q; i++) {
            findInclination(Double.parseDouble(scanner.nextLine()));
        }
        System.out.print(sb);

    }

    private static void findInclination(double new_x){
        int start = 1;
        int end = N - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (x[mid] < new_x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (y[end + 1] - y[end] < 0){
            sb.append(-1 + "\n");
        } else if (y[end + 1] - y[end] > 0){
            sb.append(1 + "\n");
        } else {
            sb.append(0 + "\n");
        }
    }
}
