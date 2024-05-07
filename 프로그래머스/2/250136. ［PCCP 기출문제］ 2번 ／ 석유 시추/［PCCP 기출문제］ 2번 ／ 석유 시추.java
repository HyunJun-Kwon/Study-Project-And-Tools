import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        int[] count = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) continue;

                Set<Integer> candidates = new HashSet<>();
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                int area = 1;
                land[i][j] = 0;
                candidates.add(j);

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int a = -1; a <= 1; a++) {
                        for (int b = -1; b <= 1; b++) {
                            if (((a^b)&1)!=1) continue;

                            int nr = cr+a;
                            int nc = cc+b;
                            if (nr<0||nr>=m||nc<0||nc>=n||land[nr][nc]==0) continue;

                            area++;
                            land[nr][nc] = 0;
                            candidates.add(nc);
                            q.add(new int[]{nr, nc});
                        }
                    }
                }

                for (int candidate : candidates) {
                    count[candidate] += area;
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