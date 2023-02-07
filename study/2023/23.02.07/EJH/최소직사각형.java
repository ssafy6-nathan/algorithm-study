import java.util.Arrays;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_v=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            Arrays.sort(sizes[i]);
            max_v=Math.max(max_v,sizes[i][0]);
            max_h=Math.max(max_h,sizes[i][1]);
        }
        return answer=max_v*max_h;
    }
}
