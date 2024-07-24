import java.util.*;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> hall = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            if (hall.size() < k) {
                hall.add(score[i]);
                Collections.sort(hall);
            } else {
                if (hall.get(0) < score[i]) {
                    hall.set(0, score[i]);
                    Collections.sort(hall);
                }
            }
            
            answer.add(hall.get(0));
        }
        
        return answer;
    }
}
