import java.util.HashMap;

public class P_성격_유형_검사_하기 {

        static HashMap<Character, int[]> jipu = new HashMap<Character, int[]>(){{
            put('R',new int[]{1, 1});
            put('T',new int[]{1, -1});
            put('C',new int[]{2, 1});
            put('F',new int[]{2, -1});
            put('J',new int[]{3, 1});
            put('M',new int[]{3, -1});
            put('A',new int[]{4, 1});
            put('N',new int[]{4, -1});

        }};

        public static String solution(String[] survey, int[] choices) {
            String answer = "";
            int [] score_board = new int[5];

            for (int i = 0; i < survey.length ; i++){
                String s = survey[i];
                Character t = s.charAt(0);
                int[] jipu_board = jipu.get(t);
                score_board[jipu_board[0]] += (4 - choices[i]) * jipu_board[1];
            }

            if (score_board[1] < 0){
                answer += "T";
            } else{
                answer += "R";
            }

            if (score_board[2] < 0){
                answer += "F";
            } else{
                answer += "C";
            }

            if (score_board[3] < 0){
                answer += "M";
            } else{
                answer += "J";
            }

            if (score_board[4] < 0){
                answer += "N";
            } else{
                answer += "A";
            }
            return answer;
        }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},	new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"},	new int[]{7, 1, 3}));

    }

}
