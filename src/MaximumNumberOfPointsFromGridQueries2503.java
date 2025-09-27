import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfPointsFromGridQueries2503 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {2, 5, 7},
                {3, 5, 1}
        };

        int[] queries = {5, 6, 2};
        System.out.println(Arrays.toString(new Solution().maxPoints(grid, queries)));
    }
    private static class Solution {
        int[] freq;
        public int[] maxPoints(int[][] grid, int[] queries) {
            int maxLen = queries[0];
            for (int i = 1; i < queries.length; i++) {
                maxLen = Math.max(maxLen, queries[i]);
            }
            freq = new int[maxLen];
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
            if (grid[0][0] <= maxLen) {
                pq.offer(new int[]{0, 0, grid[0][0]});
                grid[0][0] = -1;
            }
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                freq[curr[2]]++;
                for (int[] direction : directions) {
                    int ni = curr[0] + direction[0];
                    int nj = curr[1] + direction[1];
                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] != -1) {
                        int nWeight = Math.max(grid[ni][nj], curr[2]);
                        if (nWeight < freq.length) {
                            pq.offer(new int[]{ni, nj, nWeight});
                            grid[ni][nj] = -1;
                        }
                    }
                }
            }
            for (int i = 1; i < maxLen; i++) {
                freq[i] += freq[i - 1];
            }

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = freq[queries[i] - 1];
            }
            return res;
        }
    }
}
