import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        //k진수로 바꾸기
        //String으로 받아서 0을 기준으로 자르기
        //잘린 문자들을 숫자로 받아서 소수인지 판별 후 answer 올리기
        String KString = "";
        while(n > 0){
            KString = (n % k)+KString;
            n /= k;
        }
        StringTokenizer token = new StringTokenizer(KString, "0");
        while(token.hasMoreTokens()){
            long num = Long.parseLong(token.nextToken());
            if(isPrime(num))
                answer++;
        }
        
        
        return answer;
    }
    private static boolean isPrime(long num){
        if(num == 1) return false;
        if(num == 2) return true;

        for(int i = 3; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}