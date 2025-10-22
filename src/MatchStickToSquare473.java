import java.util.Arrays;

public class MatchStickToSquare473 {
    private static class Solution {
        boolean[] visited;

        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int val : matchsticks) {
                sum += val;
            }

            if (sum % 4 != 0) return false;
            int maxSideLength = sum / 4;
            Arrays.sort(matchsticks);
            visited = new boolean[matchsticks.length];
            return dfs(matchsticks, matchsticks.length - 1, new int[4], maxSideLength);
        }

        private boolean dfs(int[] matchsticks, int index, int[] sides, int maxSideLength) {
            if (index < 0) return true;
            for (int i = 0; i < 4; i++) {
                if (sides[i] + matchsticks[index] <= maxSideLength) {
                    sides[i] += matchsticks[index];
                    if (dfs(matchsticks, index - 1, sides, maxSideLength)) return true;
                    sides[i] -= matchsticks[index];
                }
            }

            return false;
        }
    }
}
