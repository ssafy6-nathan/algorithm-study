package study.nathan_algo_study.week52;

import java.util.StringTokenizer;

/**
 * 문제이름 : 공원 산책
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */

public class Programmers_공원산책 {
    //W E N S
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int r, c;
    public int[] solution(String[] park, String[] routes) {

        r = -1;
        c = -1;

        out:
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) != 'S')
                    continue;

                r = i;
                c = j;
                break out;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < routes.length; i++) {
            st = new StringTokenizer(routes[i]);
            String d = st.nextToken();
            int move = Integer.parseInt(st.nextToken());
            switch (d) {
                case "W":
                    move(0, move, park);
                    break;
                case "E":
                    move(1, move, park);
                    break;
                case "N":
                    move(2, move, park);
                    break;
                case "S":
                    move(3, move, park);
                    break;
            }
        }


        int[] answer = new int[]{r, c};

        return answer;
    }

    public void move(int d, int move, String[] park) {
        int dr = r;
        int dc = c;
        for (int i = 0; i <= move; i++) {
            dr = r + dir[d][0] * i;
            dc = c + dir[d][1] * i;

            if (dr < 0 || dr >= park.length
                    || dc < 0 || dc >= park[0].length()
                    || park[dr].charAt(dc) == 'X') {
                return;
            }
        }

        r = dr;
        c = dc;
    }
}

/*

 */
