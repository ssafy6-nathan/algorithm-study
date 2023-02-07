class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int cnt, int target, int sum){
        if(cnt == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers, cnt + 1, target, sum + numbers[cnt]); // 왼쪽
        dfs(numbers, cnt + 1, target, sum - numbers[cnt]); // 오른쪽
    }
}
