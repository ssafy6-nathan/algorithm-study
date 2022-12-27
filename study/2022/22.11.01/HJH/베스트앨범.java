import java.util.*;

public class Solution_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] a = solution(genres, plays);
        System.out.println(Arrays.toString(a));
        // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
        // [4, 1, 3, 0]
    }

    public static int[] solution(String[] genres, int[] plays) {
        // count를 하기 위해서는 Hash를 사용하고, 목록을 나타내기 위해서는 List를 사용
        int[] answer = {};
        // 장르 별 재생횟수 따로 계산
        // 먼저 각 장르별 플레이 누적값을 해쉬맵을 이용
        // ArrayList를 이용해서 누적 값에 대해서 정렬할 필요는 없음 (알아서 정렬되는 걸로 알고있음)
        int[] ids = {}; // 반환할 고유번호
        ArrayList<Integer> answers = new ArrayList<>();
        HashMap<String, Integer> genreTotalCountHashMap = new HashMap<>();
        int genres_length = genres.length;
        int plays_length = plays.length;
        for (int i = 0; i < genres_length; i++) {
            // 해시맵에 genres[i]와 같은 키값을 가진 게 있으면 더해
            if (genreTotalCountHashMap.containsKey(genres[i])) {
                genreTotalCountHashMap.put(genres[i], genreTotalCountHashMap.get(genres[i] + plays[i]));
            }
            // 없으면 해시맵에 추가
            genreTotalCountHashMap.put(genres[i], plays[i]);
        }

//        for(int i=0; i<genres_length; i++){
//            genreTotalCountHashMap.put(genres[i], genreTotalCountHashMap.getOrDefault(genres[i], 0)+plays[i]);
//        }

        // 2. 장르별로 가장 많이 재생된 노래를 수록하기 위해 내림차순으로 정렬
        // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
        // 1. 장르 선정
        ArrayList<String> genres_ordered = new ArrayList<String>(genreTotalCountHashMap.keySet());
        while(genreTotalCountHashMap.size() != 0) {
            int max = -1;
            String max_key = "";
            for (String key: genreTotalCountHashMap.keySet()) {
                int tmp_cnt = genreTotalCountHashMap.get(key);
                max = Math.max(max, tmp_cnt);
            }
            genres_ordered.add(max_key);
            genreTotalCountHashMap.remove(max_key);
        }

        // 2. 장르 내 노래 선정 (상위권 2가지 곡의 Index를 추출)
        return ids;
    }
}
