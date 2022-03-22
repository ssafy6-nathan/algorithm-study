import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // Arrays.sort(lottos);
        // Arrays.sort(win_nums);
        int zeros = 0;
        int fits = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeros++;
                continue;
            } else {
                for (int j = 0; j < 6; j++) {
                    if(lottos[i] == win_nums[j]) {
                        fits++;
                        break;
                    }
                }
            }
        }
        min = rank(fits);
        max = rank(fits + zeros);
        int[] answer = {max, min};
        return answer;
    }
    
    public static int rank(int fits) {
        switch (fits) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
        }
        return 6;
    }
}
