import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#') {
                    positions.add(new int[]{i, j});
                }
            }
        }

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            
            if (x < lux) lux = x;
            if (y < luy) luy = y;
            if (x > rdx) rdx = x;
            if (y > rdy) rdy = y;
        }
        
        
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}