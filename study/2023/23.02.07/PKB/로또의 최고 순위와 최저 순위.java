class Solution {

     public int[] solution(int[] lottos, int[] win_nums) {

         int zeroCnt = 0, sameCnt = 0;

         for (int lotto : lottos) {
             if (lotto == 0) {
                 zeroCnt++;
                 continue;
             }

             for (int win_num : win_nums) {
                 if (lotto == win_num) {
                     sameCnt++;
                     break;
                 }
             }
         }

         int cnt = 7 - sameCnt;

         return new int[]{Math.min(6, cnt - zeroCnt), Math.min(6, cnt)};

     }

 }
