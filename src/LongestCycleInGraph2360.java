import java.util.Arrays;

public class LongestCycleInGraph2360 {
    private static class Solution {
        public int longestCycle(int[] edges) {
            int n = edges.length;
            boolean[] visited = new boolean[n];
            int[] depth = new int[n];
            Arrays.fill(depth, -1);
            int res = -1;
            for (int start = 0; start < n; start++) {
                if (!visited[start]) {
                    res = Math.max(res, dfs(edges, start, visited, depth, 0));
                }
            }
            return res;
        }

        private int dfs(int[] edges, int start, boolean[] visited, int[] depth, int currLen) {
            if (edges[start] == -1) return -1;
            if (visited[start]) {
                if (depth[start] != -1) return currLen - depth[start];
                return -1;
            }
            depth[start] = currLen;
            visited[start] = true;
            int res = dfs(edges, edges[start], visited, depth, currLen + 1);
            depth[start] = -1;
            return res;
        }
    }
}
