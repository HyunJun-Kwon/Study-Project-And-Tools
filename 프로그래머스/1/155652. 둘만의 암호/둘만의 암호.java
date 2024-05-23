import java.util.*;

class Solution {
    public static String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()) {
        	skipSet.add(c);
        }
        
        List<Character> alpabetList = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++) {
        	if(!skipSet.contains(c)) {
        		alpabetList.add(c);
        	}
        }
        
        StringBuilder result = new StringBuilder();
        int listSize = alpabetList.size();
        
        for(char c : s.toCharArray()) {
        	int curIndex = alpabetList.indexOf(c);
        	
        	//curIndex가 존재하는지 확인하기 위해서 indexOf(c)의 값이 alpabetArray에 존재하지 않으면 -1을 리턴한다.
        	if(curIndex != -1) {
        		int newIndex = (curIndex + index) % listSize;
        		result.append(alpabetList.get(newIndex));
        	}
        }
        
        return result.toString();
    }
}