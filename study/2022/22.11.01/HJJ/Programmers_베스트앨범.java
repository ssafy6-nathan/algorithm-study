package study.nathan_algo_study.week34;

import java.util.*;

/**
 * 문제이름 : 베스트앨범
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */

public class Programmers_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playCnt = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (playCnt.containsKey(genres[i])) {
                int cnt = playCnt.get(genres[i]);
                playCnt.put(genres[i], cnt + plays[i]);
            } else {
                playCnt.put(genres[i], plays[i]);
                songList.put(genres[i], new PriorityQueue<>());
            }
            songList.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<Map.Entry<String, Integer>> cntList = new ArrayList<>(playCnt.entrySet());
        cntList.sort((o1, o2) -> (o2.getValue()) - o1.getValue());

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < cntList.size(); i++) {
            String genre = cntList.get(i).getKey();
            answer.add(songList.get(genre).poll().id);
            if (!songList.get(genre).isEmpty())
                answer.add(songList.get(genre).poll().id);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Song implements Comparable<Song> {
        public int id;
        public int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (o.play - this.play == 0)
                return this.id - o.id;  //오름차순
            else
                return o.play - this.play;  //내림차순
        }
    }
}

/*

 */
