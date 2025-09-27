import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePathInTree2467 {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        int bob = 3;
        int[] amount = {-5644, -6018, 1188, -8502};

        System.out.println(new Solution().mostProfitablePath(edges, bob, amount));
    }
    private static class Solution {
        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            List<List<Integer>> graph = new ArrayList<>();
            int n = amount.length;

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            int[] depth = new int[n];
            Arrays.fill(depth, Integer.MAX_VALUE);
            dfs(graph, bob, -1, 0, depth);
            return maxProfit(graph, 0, 0, 0, depth, 0, amount);
        }

        public boolean dfs(List<List<Integer>> graph, int start, int parent, int currDepth, int[] depth) {
            depth[start] = currDepth;
            if (start == 0) return true;
            for (int dest : graph.get(start)) {
                if (dest != parent && dfs(graph, dest, start, currDepth + 1, depth)) {
                    return true;
                }
            }
            depth[start] = Integer.MAX_VALUE;
            return false;
        }

        public int maxProfit(List<List<Integer>> graph, int start, int parent, int currDepth, int[] depth, int currProfit, int[] amount) {
            if (currDepth < depth[start]) {
                currProfit += amount[start];
            } else if (currDepth == depth[start]) {
                currProfit += amount[start] / 2;
            }

            if (start != parent && graph.get(start).size() == 1) {
                return currProfit;
            }

            int res = Integer.MIN_VALUE;
            for (int dest : graph.get(start)) {
                if (dest != parent) {
                    res = Math.max(res, maxProfit(graph, dest, start, currDepth + 1, depth, currProfit, amount));
                }
            }
            return res;
        }
    }
}
