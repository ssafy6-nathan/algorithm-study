import java.util.*;
 
public class Main {
 
    static int n;
    
    public static void main(String[] args) {
 
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        
      // 역순
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                q.offer(in.nextInt());
            }
        }
        
        for(int i=0; i<n-1; i++) {
            q.poll();
        }
        
        System.out.println(q.poll());
    }
 
}
