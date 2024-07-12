import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Set<Integer> numberSet = new HashSet<>();
        Set<Integer> inputSet = new HashSet<>();
        
        for(int i=0; i<10; i++) {
            numberSet.add(i);
        }
        
        for (int number : numbers) {
            inputSet.add(number);
        }
        
        numberSet.removeAll(inputSet);
        
        List<Integer> list = new ArrayList<>(numberSet);
        
        for(int i : list) {
            answer += i;
        }
        
        return answer;
    }
}