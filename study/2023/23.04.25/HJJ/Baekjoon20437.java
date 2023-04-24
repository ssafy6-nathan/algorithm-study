package study.nathan_algo_study.week54;

import java.io.*;

/**
 * 문제이름 : 문자열 게임 2
 * 링크 : https://www.acmicpc.net/problem/20437
 */

public class Baekjoon20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if (k == 1)
                bw.write("1 1");
            else
                bw.write(find(str, k));

            if (i != t - 1)
                bw.newLine();
        }
        bw.close();
    }

    public static String find(String str, int k) {
        int[] countArr = new int[26];
        for (int i = 0; i < str.length(); i++)
            countArr[str.charAt(i) - 'a']++;    //알파벳 갯수 저장

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length() - k + 1; i++) {
            char c = str.charAt(i); //현재 알파벳 기억
            if (countArr[c - 'a'] < k)  //현재 알파벳의 갯수가 k개보다 작으면 조건에 충족할 수 없으므로 무시
                continue;

            int count = 1;  //현재 알파벳 갯수 1
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) //현재 알파벳 다음 문자들이 현재 알파벳이랑 같으면 갯수 카운트
                    count++;

                if (count == k) {   //k개 되면
                    int wordLen = j - i + 1;    //현재 탐색한 문자열 길이
                    if (min > wordLen)
                        min = wordLen;
                    if (max < wordLen)
                        max = wordLen;

                    countArr[c - 'a']--;  //한번 확인한 알파벳은 카운트 내림 (최적화)
                    break;
                }
            }
        }
        if (min==Integer.MAX_VALUE) //한번도 바뀐적없으면 만드는거 불가능
            return "-1";
        else
            return min + " " + max;
    }
}

/*
1. end를 오른쪽으로 이동하면서 어떤문자를 정확히 K개 포함하는 문자열 완성
2. start를 오른쪽으로 이동하면서 가장 짧은 문자열로 만듬 -> 길이저장
end가 W의 마지막문자열까지 갈 때까지 반복 1번 2번 반복

1. end를 오른쪽으로 이동하면서 어떤문자를 정확히 K개 포함하는 문자열 완성
2. start를 오른쪽으로 이동하면서 end에 위치한 문자와 start에 위치한 문자를 같게 맞춤

*/
