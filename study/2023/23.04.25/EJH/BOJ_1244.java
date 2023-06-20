import java.util.Scanner;

public class BOJ_1244 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cnt = 0;
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int G = sc.nextInt();
            int num = sc.nextInt();

            if(G == 1){
                for(int j = num - 1; j < N; j+=num)
                    arr[j]^=1;
            } else if (G == 2) {
                int l = num - 2;
                int r = num;

                while(true) {
                    if(l<0 || r >= N) break;
                    if(arr[l] != arr[r]) break;
                    l--; r++;
                }
                l++; r--;

                while(l<=r) {
                    arr[l] ^=1;
                    l++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
            if((i+1)%20==0) System.out.println();
        }
    }
}
