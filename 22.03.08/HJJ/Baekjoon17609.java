package study.nathan_algo_study.week2;

import java.io.*;

/**
 * 문제이름 : 회문
 * 링크 : https://www.acmicpc.net/problem/17609
 */

public class Baekjoon17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String inputStr = br.readLine();

            bw.write(palindromeCheck(inputStr) + "\n");
        }
        br.close();
        bw.close();

    }

    //회문이면 0, 유사회문이면 1, 모두아니면 2
    public static int palindromeCheck(String str) {

        boolean isPalindrome = true;

        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            return 0;

        if (isSimilarPalindrome(new StringBuilder(str)))
            return 1;
        else
            return 2;
    }

    private static boolean isSimilarPalindrome(StringBuilder str) {
        boolean isDelete = false;
        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) == str.charAt(j))
                continue;

            //두 문자가 서로 다를 경우
            if (isDelete)   //이미 한문자 지웠으면 유사회문조차 아님
                return false;

            if (str.length() % 2 == 0 && i == str.length() / 2 - 1)  //마지막 순서의 두 문자가 다르면 하나를 지워줌으로써 회문을 만들 수 있다.
                return true;

            boolean leftmoveEqual = str.charAt(i + 1) == str.charAt(j); //왼쪽인덱스를 한칸 이동한 문자가 오른쪽 인덱스 문자와 같은지
            boolean rightMoveEqual = str.charAt(i) == str.charAt(j - 1);//오른쪽인덱스를 한칸 이동한 문자가 왼쪽 인덱스 문자와 같은지
            if (leftmoveEqual && rightMoveEqual) {  //왼쪽 이동, 오른쪽 이동 둘다 유사회문이 되는 경우
                if (str.charAt(i + 2) == str.charAt(j - 1)) {   // 왼쪽확인
                    boolean isPalindrome = true;
                    for (int k = i + 2, m = j - 1; k < str.length() / 2; k++, m--) {
                        if (str.charAt(k) != str.charAt(m)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome)
                        return true;
                }

                if (str.charAt(i + 1) == str.charAt(j - 2)) {   //오른쪽 확인
                    boolean isPalindrome = true;
                    for (int k = i + 1, m = j - 2; k < str.length() / 2; k++, m--) {
                        if (str.charAt(k) != str.charAt(m)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome)
                        return true;
                }

                return false;
            } else if (leftmoveEqual) { //왼쪽이동으로만 유사회문이 되면
                str.deleteCharAt(i);
                j--;
                isDelete = true;
            } else if (rightMoveEqual) { //오른쪽이동으로만 유사회문이 되면
                str.deleteCharAt(j);
                j--;
                isDelete = true;
            } else
                return false;

        }
        return true;
    }
}

/*

*/
