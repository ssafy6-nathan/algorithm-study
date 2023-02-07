import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //두번째 값 기준으로 정렬
        Arrays.sort(routes, (o1, o2)->{
            return o1[1]-o2[1];
        });
        
        int answer = 0;
        
        //첫번째 오는 값을 카메라로 정하고
        //다음 인덱스부터 그 간격 사이에 카메라 있는지 없는지 체크하고 있으면 넘기고
        //없으면 카메라 추가하고 값 바꾸기
        int cam = routes[0][1];
        answer++;
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= cam && routes[i][1] >= cam)
                continue;
            cam = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}
