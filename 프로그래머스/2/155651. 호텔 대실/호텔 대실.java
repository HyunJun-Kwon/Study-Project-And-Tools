import java.util.*;
import java.text.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = countRoom(book_time);
        return answer;
    }
    
    public int countRoom(String[][] book_time) {
        SimpleDateFormat date = new SimpleDateFormat("HH:mm");
        int bookCount = book_time.length;
        
        Date[] startTime = new Date[bookCount];
        Date[] endTime = new Date[bookCount];
        
        for(int i=0; i<bookCount; i++) {
            
            try {
                startTime[i] = date.parse(book_time[i][0]);
                endTime[i] = date.parse(book_time[i][1]);
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endTime[i]);
                calendar.add(Calendar.MINUTE, 10);
                endTime[i] = calendar.getTime();
            } catch(ParseException e) {
                e.printStackTrace();
            }
            
        }
        
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        int startP = 0;
        int endP = 0;
        int maxRoom = 0;
        int needRoom = 0;
        
        while(startP < bookCount) {
            if(startTime[startP].before(endTime[endP])) {
                needRoom++;
                startP++;
            } else {
                needRoom--;
                endP++;
            }
            maxRoom = Math.max(maxRoom, needRoom);
        }
        
        return maxRoom;
    }
}