package study.nathan_algo_study.week6;

/**
 * 문제이름 : 금과 은 운반하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/86053
 */

public class Programmers_GoldAndSilverCarry {
    public static void main(String[] args) {
        Programmers_GoldAndSilverCarry p = new Programmers_GoldAndSilverCarry();

        p.solution(90,500,new int[]{70,70,0}, new int[]{0,0,500}, new int[]{100,100,2}, new int[]{4,8,1});
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long)(1e9 * 2 * 1e5 * 2);    //최대 시간 = 최대 금과 은의 무게의 합 (1e9 * 2) + 왕복 이동하는 시간 (1e5 * 2)

        long start = 0;
        long end = answer;

        while (start <= end) {
            long mid = (start + end) / 2;
            long gold = 0;  //이번 경우의 수에 얻을 수 있는 금의 양
            long silver = 0;//이번 경우의 수에 얻을 수 있는 은의 양
            long sum = 0;   //이번 경우의 수에 얻을 수 있는 금과 은의 합

            for (int i = 0; i < g.length; i++) {    //경우의 수마다 모든 도시는 새도시를 짓기 위해 금과 은을 동시에 나름
                long currG = g[i];
                long currS = s[i];
                long currW = w[i];
                long currT = t[i];

                long move = (long)Math.floor(mid / (currT * 2));  //시간동안 왕복 횟수
                if (mid % (currT * 2) >= t[i])
                    move++;

                long totalW = move * currW; //시간동안 옮길 수 있는 최대 무게

                gold += Math.min(currG, totalW);
                silver += Math.min(currS, totalW);
                sum += Math.min(currG + currS, totalW);
            }

            if (gold >= a && silver >= b && sum >= a + b) { //시간안에 모두 이동가능하면
                end = mid - 1;  //시간을 더 줄여봄
                answer = mid;
            } else {    //시간안에 모두 이동 불가하면
                start = mid + 1;    //시간을 늘려봄
            }
        }

        return answer;
    }
}

/*
파라메트릭 서치 적용


 */