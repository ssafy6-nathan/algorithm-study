package week49;

/**
 * 프로그래머스 161990번
 * 덧칠하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/161989)
 **/
public class Programmers_160585 {
    public static void main(String[] args) {
        String[][] board = {{"O.X", ".O.", "..X"},
                {"OOO", "...", "XXX"},
                {"...", ".X.", "..."},
                {"...", "...", "..."}};

        for (String[] strings : board)
            System.out.println(solution(strings));
    }

    public static int solution(String[] board) {
        int answer = -1;

        // 0. board -> 2D Array
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = board[i].charAt(j);

        // 1. 변수 선언
        int count_O = 0; // O의 개수
        int count_X = 0; // X의 개수
        int bingo_O = 0; // O의 빙고 개수
        int bingo_X = 0; // X의 빙고 개수

        // 2. 틱택토판 탐색
        for (int i = 0; i < 3; i++) { // 2-1. O,X 개수 카운팅
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'O') count_O++;
                if (grid[i][j] == 'X') count_X++;
            }
        }

        for (int i = 0; i < grid.length; i++) { // 2-2. 빙고 개수 카운팅
            char c = grid[i][i];
            if (c == '.') continue;
            if ((grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2])) { // 가로 빙고
                if (c == 'O') bingo_O++;
                else bingo_X++;
            }
            if ((grid[0][i] == grid[1][i]) && (grid[1][i] == grid[2][i])) { // 세로 빙고
                if (c == 'O') bingo_O++;
                else bingo_X++;
            }
        }
        char c = grid[1][1]; // 대각선 빙고
        if ((grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2])) {
            if (c == 'O') bingo_O++;
            else bingo_X++;
        }
        if ((grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0])) {
            if (c == 'O') bingo_O++;
            else bingo_X++;
        }

        // 3. 불가능 조건 (놓는 순서가 잘못된 경우, 승리 후에도 끝나지 않은 경우)

        // 빙고가 세 줄 이상일 경우, 승자가 두 명일 경우
        if ((bingo_O + bingo_X) > 2 || bingo_O > 0 && bingo_X > 0)
            answer = 0;

        // O 승리, O <= X 인 경우 (선공이므로 O 개수가 더 많은게 정상)
        // X 승리, O > X 인 경우 (후공이므로 O = X 인 것이 정상)
        else if ((bingo_O > 0 && count_O <= count_X) || (bingo_X > 0 && count_O > count_X))
            answer = 0;

        // O의 개수보다 X의 개수가 더 많은 경우 (O가 선공이므로 X가 O보다 적거나 같은 것이 정상)
        // O의 개수가 X의 개수보다 2개 이상 더 많은 경우 (번갈아가면서 놓기 때문에 O가 많아도 최대 1개 더 많은 것이 정상)
        else if ((count_O < count_X) || (count_O - count_X) >= 2)
            answer = 0;

        // 위 조건에 모두 해당되지 않으면 정상적인 플레이
        else
            answer = 1;

        return answer;
    }
}
