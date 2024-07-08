import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            String target = targets[i];
            int total = 0;
            
            for(char c : target.toCharArray()) {
                int min = Integer.MAX_VALUE;
                
                for(String key : keymap) {
                    int index = key.indexOf(c);
                    
                    if(index != -1) {
                        min = Math.min(min, index+1);
                    }
                }
                
                if(min == Integer.MAX_VALUE) {
                    total = -1;
                    break;
                } else {
                    total += min;
                }
                
            }
            answer[i] = total;
        }
        
        
        
        return answer;
    }
    
    
}