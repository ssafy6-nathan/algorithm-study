package week40;

import java.io.*;
import java.util.*;

/**
 * 백준 20920번
 * 영단어 암기는 괴로워 (https://www.acmicpc.net/problem/20920)
 * 분류 : 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 **/
public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Word> words = new HashMap<>(); // 단어를 저장할 해시맵
        int N = Integer.parseInt(st.nextToken()); // 단어 개수
        int M = Integer.parseInt(st.nextToken()); // 암기 기준 길이

        // 1. 단어 저장
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            // 1-1. 기준 길이를 넘지 않으면 제외
            if (str.length() < M) continue;

            // 1-2. 이미 저장된 단어일 경우 count 갱신
            if (words.containsKey(str)) {
                words.get(str).setCount(words.get(str).getCount() + 1);
            }
            // 1-3. 새로 저장되는 단어는 <key: 단어 value: Word 클래스>로 저장
            else {
                words.put(str, new Word(1, str.length(), str));
            }
        }

        // 2. 해시맵 정렬
        List<Map.Entry<String, Word>> list = new ArrayList<>(words.entrySet());
        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        // 3. 출력
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).getKey()+"\n");
        }
        bw.close();

    }

    static class Word implements Comparable<Word> {
        private int count; // 나온 횟수
        private int length; // 길이
        private String word; // 해당 단어

        public Word(int count, int length, String word) {
            this.count = count;
            this.length = length;
            this.word = word;
        }
        
        @Override
        public int compareTo(Word o) {
            int cnt = o.count - this.count; // count 기준 내림차순
            if (cnt == 0) {
                int len = o.length - this.length; // length 기준 내림차순
                if (len == 0) {
                    return this.word.compareTo(o.word); // 모두 같을 경우 사전 순 정렬
                } else return len;
            } else return cnt;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getLength() {
            return length;
        }

        public String getWord() {
            return word;
        }
    }
}


