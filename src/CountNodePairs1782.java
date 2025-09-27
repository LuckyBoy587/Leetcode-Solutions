import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountNodePairs1782 {
    private static class Solution {
        public int[] countPairs(int n, int[][] edges, int[] queries) {
            int[][] edgeRepeats = new int[n][n];
            int[] degrees = new int[n];
            for (int[] edge : edges) {
                int start = Math.min(edge[0], edge[1]);
                int end = Math.max(edge[0], edge[1]);
                edgeRepeats[start][end]++;
                degrees[start]++;
                degrees[end]++;
            }

            List<Integer> incidents = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (edgeRepeats[i][j] > 0) {
                        incidents.add(degrees[i] + degrees[j] - edgeRepeats[i][j]);
                    }
                }
            }

            Collections.sort(incidents);
            return incidents.stream().mapToInt(i -> i).toArray();
        }
    }
}
