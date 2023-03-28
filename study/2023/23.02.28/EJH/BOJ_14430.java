import java.util.*;

public class BOJ_14430 {

    static int N;
    static int M;
    static int[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                array[i][j] += Math.max(array[i-1][j], array[i][j-1]);
            }
        }

        System.out.println(array[N][M]);
    }
}
