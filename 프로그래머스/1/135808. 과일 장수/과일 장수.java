class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        int apple_count = score.length;
        
        for(int i=k; i>0; i--) {
            
            for(int j=0; j<score.length; j++) {
                if(i == score[j]) {
                    count++;
                    if(count == m) {
                        answer += (i * m);
                        if(apple_count - count  >= m) {
                            count = 0;
                        } else {
                            break;
                        }    
                    }
                }
            }
            
        }
        
        return answer;
    }
}