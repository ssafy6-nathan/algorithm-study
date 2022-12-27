import java.util.*;
import java.io.*;
import java.lang.*;

// 문자열 집합

public class Main {
    public static Set<String> set = new HashSet<String>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) set.add(br.readLine());
        for(int i=0; i<M; i++) {
            if(set.contains(br.readLine())) ++answer;
        }
        System.out.println(answer);
    }
}
