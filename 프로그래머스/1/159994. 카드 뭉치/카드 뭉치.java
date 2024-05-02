class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        String answer = "Yes";
        int cards1_count = 0;
        int cards2_count = 0;
        
        for(String goalword : goal) {
            if(cards1_count < cards1.length && goalword.equals(cards1[cards1_count])) {
                cards1_count++;
            } else if(cards2_count < cards2.length && goalword.equals(cards2[cards2_count])) {
                cards2_count++;
            } else {
                answer = "No";
                break;
            }
        }
        

        
        return answer;
    }
}
