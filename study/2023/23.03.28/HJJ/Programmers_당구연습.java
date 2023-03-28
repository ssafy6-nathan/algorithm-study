package study.nathan_algo_study.week50;

/**
 * 문제이름 : 당구 연습
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/169198
 */

public class Programmers_당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int up = (int)Math.pow(targetX - startX, 2) + (int)Math.pow(targetY - 2 * n + startY, 2);
            int down = (int)Math.pow(targetX - startX, 2) + (int)Math.pow(targetY + startY, 2);
            int left = (int)Math.pow(targetX + startX, 2) + (int)Math.pow(targetY - startY, 2);
            int right = (int)Math.pow(targetX - 2 * m + startX, 2) + (int)Math.pow(targetY - startY, 2);

            //1은 0에 대칭 2는 n,m에 대칭
            if (targetX == startX) {
                //x좌표가 같으면
                if (targetY > startY)   //위제외
                    min = Math.min(down, Math.min(left, right));
                else    //아래제외
                    min = Math.min(up, Math.min(left, right));
            } else if (targetY == startY){
                if (targetX > startX)   //오른쪽제외
                    min = Math.min(up, Math.min(down, left));
                else    //왼쪽제외
                    min = Math.min(up, Math.min(down, right));
            } else
                min = Math.min(Math.min(up, down), Math.min(left, right));

            answer[i] = min;
        }

        return answer;
    }
}

/*
y가 같으면 x축에 쿠션
x가 같으면 y축에 쿠션


*/
