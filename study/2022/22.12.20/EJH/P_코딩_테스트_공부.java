import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_코딩_테스트_공부 {

    static class Point {
        int al;
        int co;
        int cost;

        public Point(int al, int co, int cost) {
            this.al = al;
            this.co = co;
            this.cost = cost;
        }
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];

        for (int al = alp; al <= maxAlp; al++) {
            for (int co = cop; co <= maxCop; co++) {
                if (co == cop) {
                    dp[al][co] = al;
                } else if (al == alp) {
                    dp[al][co] = co;
                } else {
                    dp[al][co] = Math.min(dp[al - 1][co], dp[al][co - 1]) + 1;
                }
            }
        }


        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(alp, cop, 0));

        while (!que.isEmpty()) {
            Point point = que.poll();

            if (dp[point.al][point.co] < point.cost) {
                continue;
            }


            // alpReq, copReq, alpRwd, copRwd, cost
            int alpReq, copReq, alpRwd, copRwd, cost;
            int nextAlp, nextCop;

            for (int[] p : problems) {
                alpReq = p[0];
                copReq = p[1];
                alpRwd = p[2];
                copRwd = p[3];
                cost = p[4];
                nextAlp = Math.min(maxAlp, point.al + alpRwd);
                nextCop = Math.min(maxCop, point.co + copRwd);


                if (!(alpReq <= point.al && copReq <= point.co) ||
                        dp[nextAlp][nextCop] <= point.cost + cost) {
                    continue;
                }
                dp[nextAlp][nextCop] = point.cost + cost;
                que.offer(new Point(nextAlp, nextCop, point.cost + cost));
            }

            nextAlp = Math.min(maxAlp, point.al + 1);
            nextCop = Math.min(maxCop, point.co + 1);
            if (dp[nextAlp][point.co] > point.cost + 1) {
                dp[nextAlp][point.co] = point.cost + 1;
                que.offer(new Point(nextAlp, point.co, point.cost + 1));
            }


            if (dp[point.al][nextCop] > point.cost + 1) {
                dp[point.al][nextCop] = point.cost + 1;
                que.offer(new Point(point.al, nextCop, point.cost + 1));
            }

        }

        return dp[maxAlp][maxCop];
    }

    public static void main(String[] args) {
        System.out.println(solution(10,	10,	new int[][] {{10,15,2,1,2},{20,20,3,3,4}}));
    }
}
