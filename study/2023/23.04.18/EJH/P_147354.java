import java.util.*;
public class P_147354 {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;

            Arrays.sort(data, (d1, d2) -> {
                if(d1[col - 1] == d2[col - 1]){
                    return Integer.compare(d2[0], d1[0]);
                } else {
                    return Integer.compare(d1[col - 1], d2[col - 1]);
                }
            });

            for(int i = row_begin ; i <= row_end; i++){
                int sum = 0;
                for(int column : data[i - 1]){
                    sum += (column % (i));
                }
                answer ^= sum;
            }

            return answer;
        }
}
