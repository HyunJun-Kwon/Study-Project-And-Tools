import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            indexMap.put(players[i], i);
        }
        
        for(String playerName : callings) {
            int rank = indexMap.get(playerName);
            
            String frontPlayer = players[rank-1];
            
            indexMap.replace(frontPlayer, rank);
            players[rank] = frontPlayer;
            
            indexMap.replace(playerName, rank-1);
            players[rank-1] = playerName;
        }
        
        return players;
    }
}