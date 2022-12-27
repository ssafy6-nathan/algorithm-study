package study.nathan_algo_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제이름 : 바이러스 복제
 * 링크 : https://www.acmicpc.net/problem/9241
 */

public class Baekjoon9241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String originalDNA = br.readLine();
        String infectedDNA = br.readLine();

        int result = check(originalDNA, infectedDNA);
        System.out.println(result);
    }

    public static int check(String original, String clone) {

        int oLastIdx = original.length() - 1; //original last idx
        int cLastIdx = clone.length() - 1;    //clone last idx

        boolean[] isCheck = new boolean[original.length()];
        int minSize = Math.min(original.length(), clone.length());  //두 문자열중 더 짧은 문자열의 길이

        for (int startIdx = 0; startIdx < minSize; startIdx++) {    //접두사 체크
            if (original.charAt(startIdx) != clone.charAt(startIdx))
                break;
            isCheck[startIdx] = true;
        }

        for (int i = 0; i < minSize; i++, oLastIdx--, cLastIdx--) { //접미사 체크
            if (original.charAt(oLastIdx) != clone.charAt(cLastIdx))
                break;
            isCheck[oLastIdx] = true;
        }

        int useWord = 0;
        for (int i = 0; i < isCheck.length; i++) {
            if (isCheck[i])
                useWord++;
        }

        int result = clone.length() - useWord;
        if (result < 0) //값이 음수가 나오면 0으로 변경 (문자의 삽입없이 문자제거만 된 경우)
            result = 0;
        return result;
    }
}

/*
GTTTGAC ACACAT T
GTTTGAC CACA T
0123456 78910 11

GGGTTTTA
AGGTTTTA
01234567

GTTTGACA CACAT T
GTTTGACA T

AGCGAA
AGCGAAAGCGAA

AGCGAGCGA
AGCGAGCGAGCGA

AGCGAAAGCGAA
AGGAA

경우의 수는 3가지
1. 앞쪽 DNA가 바뀌는 경우
2. 뒤쪽 DNA가 바뀌는 경우
3. 중간 DNA가 바뀌는 경우

이 세가지를 모두 커버할 수 있는 방식은 
접두사랑 접미사를 차레대로 비교해서 똑같은 갯수 카운트하고 바뀐 문자열길이에서 빼는 것

*/
