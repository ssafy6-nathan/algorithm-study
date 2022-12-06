class Solution {
    public int solution(String s) {
        int answer = 1001;
        
        //테케 5번 - 길이 1인 문자 체크
        if(s.length() == 1){
            return 1;
        }
        
        for(int i = 1; i <= s.length()/2; i++){  
            int cnt = 0;
            //시작 문자열 잘라
            String str = s.substring(0, i);
            String sub = "";

            //다음 문자열 잘라서 비교
            for(int j = 0; j <= s.length(); j=j+i){
                int start = j;
                int end = i+j;
                
                //범위 체크
                if(end > s.length())
                    end = s.length();

                String str2 = s.substring(start, end);
                
                //같으면 개수 올려
                if(str.equals(str2)){
                    cnt++;
                }else{
                    //숫자 넣기
                    if(cnt > 1){
                        sub += cnt;
                    }
                    
                    sub += str;
                    str = str2;
                    cnt = 1;
                }
            }
            
            if(cnt > 1)
                sub += cnt;
            sub += str; 
            answer = Math.min(answer, sub.length());
            
        }
        
        return answer;
    }
}