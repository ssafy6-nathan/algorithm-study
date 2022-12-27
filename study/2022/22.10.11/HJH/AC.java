import java.util.*;
import java.io.*;
import java.lang.*;

// AC

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
 
        StringBuilder sb = new StringBuilder();
 
        while (T-->0) {
            String P = in.readLine();
            int N = Integer.parseInt(in.readLine());
 
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(in.readLine(), "[|]|,");
            while (st.hasMoreTokens()) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
 
            boolean isR = true;
            boolean error = false;
            for (int i = 0; i < P.length(); i++) {
                if (error) break;
                switch (P.charAt(i)) {
                    case 'R':
                        isR = !isR;
                        break;
                    case 'D':
                        if (deque.isEmpty()) error = true;
                        else if (isR) deque.poll();
                        else deque.pollLast();
                        break;
                }
            }
 
            if(error) {
                sb.append("error\n");
                continue;
            }
 
            sb.append("[");
            while(!deque.isEmpty()) {
                if (isR) sb.append(deque.poll());
                else sb.append(deque.pollLast());
                if(deque.size()>=1) sb.append(",");
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
