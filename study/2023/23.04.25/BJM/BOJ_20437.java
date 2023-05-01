package week54;

import java.io.*;

/**
 * 백준 20437번
 * 문자열 게임 2 (https://www.acmicpc.net/problem/20437)
 * 분류 : 문자열, 슬라이딩 윈도우
 **/
public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabet;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            alphabet = new int[26];
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            // k가 1이라면 최소, 최대 길이는 1이 될 수 밖에 없음
            if (k == 1) {
                bw.write("1 1\n");
                continue;
            }

            // 1. 알파벳 개수 카운트
            for (int i = 0; i < str.length(); i++)
                alphabet[str.charAt(i) - 97]++;

            // 2. 전체 문자열 순회
            int minLen = 10001; // 서브문자열 최소길이
            int maxLen = 0; // 서브문자열 최대길이
            for (int i = 0; i < str.length() - k + 1; i++) { // 문자열이 k개 미만 남았을 경우 순회할 필요 없음
                char currC = str.charAt(i); // 현재 확인 중인 문자
                if (alphabet[currC - 97] < k) continue; // k개 미만인 알파벳은 확인할 필요가 없으므로 건너뜀
                int currLen = 1; // 현재 서브문자열 길이
                int count = 1; // 현재 알파벳 카운트 (k와 비교하기 위한 변수)

                // 3. 서브 문자열 순회
                for (int j = i + 1; j < str.length(); j++) {
                    currLen++;
                    if (currC == str.charAt(j)) { // 같은 알파벳을 만나면 count 갱신
                        count++;
                    }
                    if (count == k) { // 현재 탐색 중인 알파벳이 k개가 되면 순회 중단
                        // 최소, 최대 길이 갱신
                        if (minLen > currLen) minLen = currLen;
                        if (maxLen < currLen) maxLen = currLen;
                        // 확인한 알파벳은 개수 감소 (이후에 k개 이상 남아있지 않다면 다시 확인할 필요x)
                        alphabet[currC - 97]--;
                        break;
                    }
                }
            }
            if (minLen == 10001 && maxLen == 0) bw.write("-1\n");
            else bw.write(minLen + " " + maxLen + "\n");
        }
        bw.close();
    }
}