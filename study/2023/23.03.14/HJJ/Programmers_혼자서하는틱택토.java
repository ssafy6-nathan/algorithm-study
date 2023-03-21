package study.nathan_algo_study.week49;

/**
 * 문제이름 : 혼자서 하는 틱택토
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/160585
 */

public class Programmers_혼자서하는틱택토 {
    public int solution(String[] board) {
        int bingoO = bingoCheck(board, 'O');
        int bingoX = bingoCheck(board, 'X');

        int cntO = 0;
        int cntX = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O')
                    cntO++;
                else if (board[i].charAt(j) == 'X')
                    cntX++;
            }
        }

        int answer = 1;

        //두명이 승리하는 경우 or 빙고가 3줄이상
        if ((bingoO > 0 && bingoX > 0) || (bingoO + bingoX > 2))
            answer = 0;

        //O가 X개수보다 작거나 O가 X보다 2개이상 많은 경우
        if (cntO < cntX || cntO - cntX>= 2)
            answer = 0;

        //O가 승리할 때 서로 갯수가 같으면 or X가 승리할 때 O가 갯수가 더 많으면
        if ((bingoO == 1 && cntO == cntX) || (bingoX == 1 && cntO > cntX))
            answer = 0;

        return answer;
    }

    public int bingoCheck(String[] board, char c) {
        int cnt = 0;

        //가로 세로 빙고
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c
                    && board[i].charAt(0) == board[i].charAt(1)
                    && board[i].charAt(1) == board[i].charAt(2)) {
                cnt++;
            }

            if (board[0].charAt(i) == c
                    && board[0].charAt(i) == board[1].charAt(i)
                    && board[1].charAt(i) == board[2].charAt(i)) {
                cnt++;
            }
        }

        //대각선 빙고
        if (board[0].charAt(0) == c
                && board[0].charAt(0) == board[1].charAt(1)
                && board[1].charAt(1) == board[2].charAt(2))
            cnt++;
        if (board[0].charAt(2) == c
                && board[0].charAt(2) == board[1].charAt(1)
                && board[1].charAt(1) == board[2].charAt(0))
            cnt++;

        return cnt;
    }
}

/*


1 승자가 정해진 경우
승자가 두명인경우 X




2 승자가 정해지지 않은 경우
O.size == X.size || O.size + 1 == X.size




*/
