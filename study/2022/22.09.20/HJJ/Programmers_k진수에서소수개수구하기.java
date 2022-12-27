package study.nathan_algo_study.week29;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Programmers_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        String num = convertDigit(n, k);
        return check(num);
    }

    public int check(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            if (n == '0') { //0을 만나면
                if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString()))) { // 0P0, P0
                    count++;
                }
                sb = new StringBuilder();
            } else {
                sb.append(n);
            }

            if (n != '0' && i+1 == num.length()) {  //마지막인덱스가 0이 아니면
                if (sb.length() != 0 && isPrime(Integer.parseInt(sb.toString())))   // 0P
                    count++;
            }

        }

        return count;
    }

    public boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public String convertDigit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int curr = n;

        if (k == 10)
            return String.valueOf(n);

        while(curr > 0) {
            sb.append(curr % k);
            curr /= k;
        }

        return sb.reverse().toString();
    }
}
/*

 */