import java.util.*;

class Solution {
    
    static class Point {
        int x,y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        Point border = new Point(m,n);
        Point start = new Point(startX,startY);
        
        for(int i=0; i<balls.length; i++) {
            int[] ball = balls[i];
            
            List<Point> convert = calPoint(border,start, new Point(ball[0], ball[1]));
            
            int minDistance = Integer.MAX_VALUE;
            for(Point point : convert) {
                int distance = calculateDistance(start, point);
                
                minDistance = Math.min(minDistance, distance);
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
    
    public int calculateDistance(Point start, Point ball) {
        
        int bigX = Math.max(start.x,ball.x);
        int smallX = Math.min(start.x,ball.x);
        int bigY = Math.max(start.y,ball.y);
        int smallY = Math.min(start.y,ball.y);
        
        return (int) (Math.pow((bigX - smallX), 2) + Math.pow((bigY - smallY), 2));
        
    }
    
    public List<Point> calPoint(Point border, Point start, Point target) {
        List<Point> conv = new ArrayList<>();
        
        if(!(start.x == target.x && start.y < target.y)) {
            conv.add(new Point(target.x, 2 * border.y - target.y));
        }
        
        if(!(start.x == target.x && start.y > target.y)) {
            conv.add(new Point(target.x, target.y * -1));
        }
        
        if(!(start.y == target.y && start.x < target.x)) {
            conv.add(new Point(2 * border.x - target.x, target.y));
        }
        
        if(!(start.y == target.y && start.x > target.x)) {
            conv.add(new Point(target.x * -1, target.y));
        }
        
        return conv;
    }
}