import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathWithAlternatingColors1129 {
    private static class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            boolean[][] redGraph = buildGraph(n, redEdges);
            boolean[][] blueGraph = buildGraph(n, blueEdges);

            int[] redDist = new int[n];
            int[] blueDist = new int[n];

            Arrays.fill(redDist, Integer.MAX_VALUE);
            Arrays.fill(blueDist, Integer.MAX_VALUE);

            redDist[0] = 0;
            blueDist[0] = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
                int dist1 = Math.min(redDist[i1], blueDist[i1]);
                int dist2 = Math.min(redDist[i2], blueDist[i2]);
                return Integer.compare(dist1, dist2);
            });

            pq.offer(0);
            while (!pq.isEmpty()) {
                int curr = pq.poll();
                int currRedDist = redDist[curr];
                int currBlueDist = blueDist[curr];

                for (int next = 0; next < n; next++) {
                    if (redGraph[curr][next]) {
                        if (currBlueDist != Integer.MAX_VALUE && currBlueDist + 1 < redDist[next]) {
                            redDist[next] = currBlueDist + 1;
                            pq.offer(next);
                        }
                    }

                    if (blueGraph[curr][next]) {
                        if (currRedDist != Integer.MAX_VALUE && currRedDist + 1 < blueDist[next]) {
                            blueDist[next] = currRedDist + 1;
                            pq.offer(next);
                        }
                    }
                }
            }

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                int minDist = Math.min(redDist[i], blueDist[i]);
                result[i] = (minDist == Integer.MAX_VALUE) ? -1 : minDist;
            }
            return result;
        }

        private boolean[][] buildGraph(int n, int[][] edges) {
            boolean[][] graph = new boolean[n][n];
            for (int[] edge : edges) {
                graph[edge[0]][edge[1]] = true;
            }
            return graph;
        }
    }
}
