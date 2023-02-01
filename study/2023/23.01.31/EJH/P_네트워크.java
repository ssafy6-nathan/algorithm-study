public class P_네트워크 {
    class Solution {
        public int solution(int n, int[][] computers) {
            boolean[] check = new boolean[n];
            int answer = 0;

            for(int i = 0 ; i < n ; i++){
                if(!check[i]){
                    network(i, computers, check);
                    answer += 1;
                }
            }
            return answer;
        }

        public static void network(int index,int[][] computers, boolean[] check){
            check[index] = true;
            for(int i = 0; i < computers.length ; i ++){
                if (!check[i] && computers[index][i] == 1){
                    network(i, computers, check);
                }
            }
        }
    }
}
