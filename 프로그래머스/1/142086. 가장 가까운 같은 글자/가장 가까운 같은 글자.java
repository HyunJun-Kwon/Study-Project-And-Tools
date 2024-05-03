import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        char[] sCharArray = s.toCharArray();
        Map<Integer, Character> wordMap = new HashMap<>();
        int[] answer = new int[sCharArray.length];
        
        for(int i=0; i<sCharArray.length; i++) {
            wordMap.put(i, sCharArray[i]);
        }
        
        for(int i=0; i<sCharArray.length; i++) {
            if(i < 1) {
                answer[i] = -1;
            } else {
                for(int j=i-1; j>=0; j--) {
                    char current = wordMap.get(i);
                    if(current == wordMap.get(j)) {
                        answer[i] = i-j;
                        break;
                    } else {
                        answer[i] = -1;
                    }
                }
            }
        }
        
        
        
        
        return answer;
    }
}