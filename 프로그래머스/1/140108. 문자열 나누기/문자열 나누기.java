class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;
        char firstLetter = s.charAt(0);
        
        for(int i=0; i<s.length(); i++) {
            
            char currLetter = s.charAt(i);
            
            if(firstLetter == currLetter) {
                sameCount++;
            } else {
                diffCount++;
            }
            
            if(sameCount == diffCount && i != s.length()-1) {
                answer++;
                firstLetter = s.charAt(i+1);
                sameCount = 0;
                diffCount = 0;
            } else if(sameCount != diffCount && i == s.length()-1) {
                answer++;
            } else if(sameCount == diffCount && i == s.length()-1) {
                answer++;
            }
      
        }
        
        return answer;
    }
}