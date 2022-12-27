package week34;

import java.util.*;

/**
 * 프로그래머스 42579번
 * 베스트앨범
 * (https://school.programmers.co.kr/learn/courses/30/lessons/42579)
 **/
public class Programmers_42579 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    private static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> idNum = new ArrayList<>(); // 정답 리스트
        Map<String, Integer> totalPlays = new HashMap<>(); // 장르 별 전체 재생횟수
        Map<String, Map<Integer, Integer>> genreSort = new HashMap<String, Map<Integer, Integer>>(); // 장르 내 음악의 고유번호와 재생횟수 저장

        // 1. 전체 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            // 해시맵에 없는 장르이면 그대로 재생횟수 저장
            if (!totalPlays.containsKey(genres[i]))
                totalPlays.put(genres[i], plays[i]);
            // 해시맵에 있는 장르이면 누적된 재생횟수를 값으로 하여 저장
            else
                totalPlays.put(genres[i], (totalPlays.get(genres[i]) + plays[i]));
        }

        // 2. 고유번호와 재생횟수 저장
        for (int i = 0; i < genres.length; i++) {
            // 해시맵에 없는 장르이면, 장르를 키로 설정하여 새로운 해시맵(k:고유번호, v:재생횟수)을 값에 생성
            if (!genreSort.containsKey(genres[i]))
                genreSort.put(genres[i], new HashMap<Integer, Integer>());
            // 해당 장르의 musicPlays 해시맵(= 현재 키 값의 value)에 접근하여 고유번호, 재생횟수 기록
            genreSort.get(genres[i]).put(i, plays[i]);
        }

        // 3. 전체 재생횟수 정렬
        List<Map.Entry<String, Integer>> totalEntry = new LinkedList<>(totalPlays.entrySet()); // 정렬을 위해 entrySet 전환
        totalEntry.sort(((o1, o2) -> totalPlays.get(o2.getKey()) - totalPlays.get(o1.getKey()))); // 람다식을 이용한 정렬

        // 4. 장르 별 곡들의 재생횟수 정렬 후 정답 배열에 저장
        // 해당 반복문의 변수는 엔트리, 즉 해시맵의 (key, value)를 하나의 인덱스로 인식함 -> key.getKey() = 장르이름
        // 정렬된 totalPlays 해시맵의 키 값을 이용하여 재생횟수가 높은 순서부터 차례대로 순회
        for(Map.Entry<String, Integer> genre : totalEntry){
            int count = 0;

            // 현재 genreSort.get(key.getKey())는 각 곡의 고유번호와 재생횟수가 기록된 해시맵 객체를 가리킴
            List<Map.Entry<Integer, Integer>> musicEntry = new LinkedList<>(genreSort.get(genre.getKey()).entrySet());
            musicEntry.sort(((o1, o2) -> genreSort.get(genre.getKey()).get(o2.getKey()) - genreSort.get(genre.getKey()).get(o1.getKey())));

            for(Map.Entry<Integer, Integer> entry : musicEntry){
                if(count == 2 || entry.getKey() == null) break; // 상위 2개가 저장되었거나, 장르에 곡이 한 개 밖에 없다면 종료
                idNum.add(entry.getKey()); // 해당 고유번호를 저장
                count++;
            }
        }
        // 리스트를 배열로 바꾸어 반환
        answer = new int[idNum.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = idNum.get(i);
        return answer;
    }
}
