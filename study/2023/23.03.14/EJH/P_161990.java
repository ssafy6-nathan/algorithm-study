public class P_161990 {
    //바탕화면 정리
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = {};
            int min_r, max_r, min_c, max_c;
            int R = wallpaper.length;
            int C = wallpaper[0].length();
            max_r = 0;
            max_c = 0;
            min_r = R + 1;
            min_c = C + 1;
            for (int i = 0; i < R ; i++){
                for(int j = 0; j < C; j++){
                    if(wallpaper[i].charAt(j) == '#'){
                        if(max_r < i) max_r = i;
                        if(max_c < j) max_c = j;
                        if(min_r > i) min_r = i;
                        if(min_c > j) min_c = j;
                    }
                }
            }
            System.out.print(min_r +" "+ min_c +" "+ max_r +" "+ max_c);
            return new int[] {min_r , min_c , max_r + 1, max_c + 1};
        }
    }
}
