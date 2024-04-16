class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String now = board[h][w];
        int n = board.length;
        int m = board[0].length;
        
        int [] ax = {-1,1,0,0};
        int [] ay = {0,0,-1,1};
        
        for(int i=0; i<4; i++) {
            int x = h + ax[i];
            int y = w + ay[i];
            
            if(x >= 0 && x < n && y >= 0 && y < m && now.equals(board[x][y])) {
                answer++;
            }
        }
        
        return answer;
        
    }
}