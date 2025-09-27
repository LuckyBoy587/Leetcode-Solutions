public class MissingAndRepeated2965 {
    private static class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int currSum = 0, rep = -1;
            boolean[] visited = new boolean[n * n + 1];

            for (int[] row : grid) {
                for (int num: row) {
                    if (!visited[num]) {
                        currSum += num;
                        visited[num] = true;
                    } else {
                        rep = num;
                    }
                }
            }

            int totalSum = n * n * (n * n + 1) / 2;
            return new int[]{rep, totalSum - currSum};
        }
    }
}
