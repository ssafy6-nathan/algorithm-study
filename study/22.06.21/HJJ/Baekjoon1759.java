package study.nathan_algo_study.week17;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 암호 만들기
 * 링크 : https://www.acmicpc.net/problem/1759
 */

public class Baekjoon1759 {
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static int L, C;
    static char[] alphabet;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);

        sb = new StringBuilder();
        search(0, 0, new boolean[C], new char[L]);
        System.out.println(sb.toString());

    }

    public static void search(int cnt, int idx, boolean[] v, char[] p) {
        if (cnt == L) {
            if (!isValid(p))
                return;

            for (int i = 0; i < p.length; i++)
                sb.append(p[i]);
            sb.append("\n");

            return;
        }

        for (int i = idx; i < C; i++) {
            if (v[i])
                continue;

            p[cnt] = alphabet[i];
            v[i] = true;

            search(cnt + 1, i + 1, v, p);

            v[i] = false;
        }
    }

    public static boolean isValid(char[] p) {
        int vowelCnt = 0;
        int consonantCnt = 0;
        for (int i = 0; i < p.length; i++) {
            boolean isVoewl = false;
            for (int j = 0; j < vowel.length; j++) {
                if (p[i] == vowel[j]) {
                    isVoewl = true;
                    break;
                }
            }
            if (isVoewl)
                vowelCnt++;
            else
                consonantCnt++;
        }

        if (vowelCnt >= 1 && consonantCnt >= 2)
            return true;
        else
            return false;
    }
}

/*
a t c i s w

a c i s t w

 */
