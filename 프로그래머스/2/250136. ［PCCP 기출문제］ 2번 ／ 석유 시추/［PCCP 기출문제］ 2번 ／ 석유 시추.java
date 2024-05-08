import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        int[] count = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    continue;
                } 
                
                Set<Integer> number = new HashSet<>();
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                int area = 1;
                land[i][j] = 0;
                number.add(j);

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int a = -1; a <= 1; a++) {
                        for (int b = -1; b <= 1; b++) {
                            if (Math.abs(a-b) % 2 != 1) continue;

                            int nr = cr+a;
                            int nc = cc+b;
                            if (nr<0||nr>=m||nc<0||nc>=n||land[nr][nc]==0) continue;

                            area++;
                            land[nr][nc] = 0;
                            number.add(nc);
                            q.add(new int[]{nr, nc});
                        }
                    }
                }

                for (int weightNum : number) {
                    count[weightNum] += area;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) max = count[i];
        }
        return max;
    }
}