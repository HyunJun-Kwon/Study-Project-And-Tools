import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static char map[][];
    static boolean visited[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        visited = new boolean[n][m];
        map = new char[n][m]; 
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    list.add(bfs(i,j,map.length,map[i].length));
                }
            }
        }
        
        int answer[] = list.stream().mapToInt(Integer::intValue).sorted().toArray();
        
        return answer.length == 0 ? new int[]{-1} : answer;
        
    }
    
    static int bfs(int x, int y, int height, int width) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        int sum = 0;
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            sum += map[now.x][now.y] - '0';
            
            for(int i=0; i<4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) {
                    continue;
                } else {
                    if(!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                        queue.add(new Node(nextX,nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return sum;
    }
}
