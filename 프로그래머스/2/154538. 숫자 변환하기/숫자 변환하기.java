import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            int currentOperations = current[1];

            int[] nextStates = {currentValue + n, currentValue * 2, currentValue * 3};

            for (int nextState : nextStates) {
                if (nextState == y) {
                    return currentOperations + 1;
                }
                if (nextState < y && !visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(new int[]{nextState, currentOperations + 1});
                }
            }
        }

        return -1;
    }
}