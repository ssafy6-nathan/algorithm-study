import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE; // 최솟값
        long min_s = 0; // 시작 최솟값
        long min_m = 0; // 중간 최솟값
        long min_e = 0; // 끝 최솟값

        long num = 0L;
        int start = 0;

        while(start < n-2) { 
            int mid = start+1;
            int end = n-1; 

            while(mid < end){
                num = arr[start] + arr[mid] + arr[end];

                if(Math.abs(min) >= Math.abs(num)) {
                    min = Math.abs(num);
                    min_s = arr[start];
                    min_m = arr[mid];
                    min_e = arr[end];
                }

                if(num==0) break;
                else if(num < 0) mid++;
                else end--;
            }

            start++;
        }

        bw.write(min_s+" "+min_m+" "+min_e + "\n");

        br.close();
        bw.flush();

    }
}
