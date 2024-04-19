class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int nameNum = name.length;
        String[] photoName = {};
        
        int index = 0;
        
        for(String[] nameList : photo) {
            int score = 0;
            for(String photoNames : nameList) {                
                for(int i=0; i<nameNum; i++) {
                    if(photoNames.equals(name[i])) {
                        score += yearning[i];
                    }
                }
            }
            answer[index++] = score;
        }
        
        
        
        return answer;
    }
}