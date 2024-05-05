import java.lang.Math;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int large = Math.max(a,b);
        int small = Math.min(a,b);
        
        answer = ((long) (large-small+1)*(large+small) / 2);
        
        return answer;
    }
}