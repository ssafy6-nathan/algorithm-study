import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_18870 {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int cnt = 0;
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = arr.clone();

        Arrays.sort(arr);

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++) {
            if(!hmap.containsKey(arr[i]))
                hmap.put(arr[i], cnt++);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N ; i++) {
            sb.append(hmap.get(temp[i])).append(" ");
        }

        System.out.println(sb);

    }
}
