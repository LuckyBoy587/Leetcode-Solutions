import java.util.*;

public class ShortestCycleInGraph2608 {
    private static class Solution {
        public int findShortestCycle(int n, int[][] edges) {
            List<List<Integer>> graph = buildGraph(edges, n);
            int minDistance = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                Queue<Integer> queue = new LinkedList<>();
                int[] depth = new int[n];
                Arrays.fill(depth, -1);
                queue.add(i);
                depth[i] = 0;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    visited[curr] = true;
                    for (int next : graph.get(curr)) {
                        if (depth[next] == -1) {
                            depth[next] = depth[curr] + 1;
                            queue.add(next);
                        } else if (depth[next] >= depth[curr]) {
                            minDistance = Math.min(minDistance, depth[next] + depth[curr] + 1);
                        }
                    }
                }
            }

            return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
        }

        private List<List<Integer>> buildGraph(int[][] edges, int V) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            return graph;
        }
    }
}
