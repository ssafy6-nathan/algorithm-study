public class P_160585 {
    //혼자서 하는 틱택토
    class Solution {
        public char[][] map;
        public int win(char c) {
            int game = 0;
            for(int i = 0; i < 3; i++)
            {
                if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                    game++;
                if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                    game++;
            }
            if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2])
                game++;
            if(map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0])
                game++;
            return game;
        }

        public int solution(String[] board) {
            int answer = 1;
            map = new char[3][3];
            int count_o = 0;
            int count_x = 0;
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    map[i][j] = board[i].charAt(j);
                    if(map[i][j] == 'O')
                        count_o++;
                    if(map[i][j] == 'X')
                        count_x++;
                }
            }

            if(count_o < count_x || count_o - count_x > 1)
                return 0;
            if(win('O') > 0 && win('X') > 0)
                return 0;
            if(win('O') > 0) {
                if(count_o != count_x + 1)
                    return 0;
            }
            if(win('X') > 0) {
                if(count_o > count_x)
                    return 0;
            }
            return answer;
        }
    }
}
