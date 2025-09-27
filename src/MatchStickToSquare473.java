public class MatchStickToSquare473 {
    private static class Solution {
        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int val : matchsticks) {
                sum += val;
            }

            if (sum % 4 != 0) return false;
            int side = sum / 4;
            return dfs(matchsticks, 0, new int[4], side);
        }

        private boolean dfs(int[] sticks, int index, int[] sideLengths, int side) {
            if (index == sticks.length) return true;
            for (int i = 0; i < sideLengths.length; i++) {
                if (sideLengths[i] + sticks[index] <= side) {
                    sideLengths[i] += sticks[index];
                    if (dfs(sticks, index + 1, sideLengths, side)) return true;
                    sideLengths[i] -= sticks[index];
                }
            }

            return false;
        }
    }
}
