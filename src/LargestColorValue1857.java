import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestColorValue1857 {

    public static void main(String[] args) {
        // Input parameters for the test case
        String colors = "rrrde";
        int[][] edges = {{4, 2}, {3, 4}, {0, 3}, {1, 0}, {2, 1}};

        // Creating an instance of the Solution class and invoking the largestPathValue method
        Solution solution = new Solution();
        int result = solution.largestPathValue(colors, edges);

        // Printing the result
        System.out.println("The largest path value is: " + result);
    }

    private static class Solution {
        private final List<Integer> EMPTY_LIST = new ArrayList<>();
        int res = -1;
        int[][] dp;

        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            dp = new int[n][26];
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                if (from == to) return -1;
                graph.computeIfAbsent(from, _ -> new ArrayList<>()).add(to);
            }

            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (dfs(i, new boolean[n], colors, graph, visited)) {
                    return -1;
                }
            }

            return res;
        }

        private boolean dfs(int node, boolean[] currPath, String colors, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
            if (currPath[node]) return true;
            if (visited[node]) return false;
            currPath[node] = true;
            visited[node] = true;

            for (int next : graph.getOrDefault(node, EMPTY_LIST)) {
                if (dfs(next, currPath, colors, graph, visited)) return true;
                for (int i = 0; i < 26; i++) {
                    dp[node][i] = Math.max(dp[node][i], dp[next][i]);
                }
            }

            currPath[node] = false;
            res = Math.max(res, ++dp[node][colors.charAt(node) - 'a']);
            return false;
        }
    }
}
