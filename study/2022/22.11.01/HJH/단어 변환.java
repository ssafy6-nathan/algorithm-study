import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int targetIndex = searchTarget(target, words);
        if (targetIndex < 0) {
            return 0;
        }
        int[] visited = new int[words.length];
        bfs(begin, words, visited);
        return visited[targetIndex];
    }
  
    private static int searchTarget(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    private static void bfs(String begin, String words[], int visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(-1);

        while (!q.isEmpty()) {
            int currentIndex = q.poll();
            String currentWord = "";

            if (currentIndex == -1) {
                currentWord = begin;
            } else {
                currentWord = words[currentIndex];
            }

            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int j = 0; j < currentWord.length(); j++) {
                    if (currentWord.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }

                if (diff == 1 && visited[i] == 0) {
                    if (currentIndex == -1) {
                        visited[i] = 1;
                    } else {
                        visited[i] = visited[currentIndex] + 1;
                    }
                    q.offer(i);
                }
            }
        }
    }
}
