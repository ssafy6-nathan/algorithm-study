public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int matched = 0;

        for (int l : lottos) {
            if (l == 0) zero++;
            else {
                for (int w : win_nums) {
                    if (l == w) {
                        matched++;
                        break;
                    }
                }
            }
        }

        int min = matched;
        int max = matched + zero;

        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }
}
