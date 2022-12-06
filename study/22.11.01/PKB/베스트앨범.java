import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        Map<String, Integer> map = new HashMap<>();

        // 장르별 총 재생횟수
        for (int i = 0; i < len; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(map.keySet());
        // 재생횟수 내림차순으로 장르 정렬
        Collections.sort(genreList, (s1, s2) -> map.get(s2) - map.get(s1));

        List<Integer> idxList = new ArrayList<>();

        for (int i = 0, size = genreList.size(); i < size; i++) {
            String genre = genreList.get(i);

            // 재생횟수 최댓값
            int max = 0;
            // 가장 많이 재생된 노래의 고유 번호
            int firstIdx = -1;

            // 가장 많이 재생된 노래의 고유 번호 찾기
            for (int j = 0; j < len; j++) {
                if (genre.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            // 두 번째로 많이 재생된 노래의 고유 번호
            int secondIdx = -1;

            // 두 번째로 많이 재생된 노래의 고유 번호 찾기
            for (int j = 0; j < len; j++) {
                if (genre.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            // 리스트에 고유 번호 저장
            idxList.add(firstIdx);
            if (secondIdx != -1) idxList.add(secondIdx);
        }

        // List -> Array
        return idxList.stream().mapToInt(i -> i).toArray();

    }

}
