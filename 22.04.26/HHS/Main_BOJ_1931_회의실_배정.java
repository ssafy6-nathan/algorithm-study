package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1931_회의실_배정 {

    static class Time implements Comparable<Time>{
        
    	int start;
        int end;
        
        public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
        
        @Override
		public int compareTo(Time o) {
    
            if(this.end == o.end)
                return Integer.compare(this.start, o.end);
            else
            	return Integer.compare(this.end, o.end);
		}
    }

    
    static int N;
    static Time [] meeting;
    static int result;
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        meeting = new Time[N];

        for(int i = 0; i < N; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            meeting[i] = new Time(start, end);
        }

        Arrays.sort(meeting);

        int end_temp = 0;
        for (int i = 0; i < N; i++) {
            if(end_temp <= meeting[i].start){
                end_temp = meeting[i].end;
                result++;
            }
        }
        System.out.println(result);

    }
}
