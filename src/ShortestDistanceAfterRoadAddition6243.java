import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceAfterRoadAddition6243 {
    private static class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            int[][] dp = new int[n][n];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int i = 0; i + 1 < n; i++) {
                dp[i][i + 1] = 1;
            }

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];
                dp[start][end] = 1;
                result[i] = findShortestDistance(dp, n);
            }
            return result;
        }

        private int findShortestDistance(int[][] graph, int n) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;

            for (int i = 0; !queue.isEmpty(); i++) {
                int size = queue.size();
                while (size-- > 0) {
                    int curr = queue.poll();
                    if (curr == n - 1) {
                        return i;
                    }
                    for (int dest = 0; dest < graph.length; dest++) {
                        if (graph[curr][dest] == 1 && !visited[dest]) {
                            visited[dest] = true;
                            queue.add(dest);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
