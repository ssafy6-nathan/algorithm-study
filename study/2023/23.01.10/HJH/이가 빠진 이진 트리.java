// 이가 빠진 이진 트리
import java.util.*;
import java.io.*;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sauce = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1) sauce = i;
        }
        arr[sauce] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        dfs(0, N);
        System.out.println(sb);
    }

    public static void dfs(int start, int size) {
        if (size == 1) {
            sb.append(arr[start]).append(" ");
        } else {
            int mid = size / 2;
            dfs(start, mid);
            dfs(start + mid + 1, mid);
            sb.append(arr[start + mid]).append(" ");
        }
    }
}
