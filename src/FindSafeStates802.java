import java.util.ArrayList;
import java.util.List;

public class FindSafeStates802 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(new Solution().eventualSafeNodes(arr));
    }

    private static class Solution {
        boolean[] isCycleNode;
        boolean[] isSafeNode;
        boolean[] visited;
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            isCycleNode = new boolean[n];
            isSafeNode = new boolean[n];
            visited = new boolean[n];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if (!hasCycle(graph, i)) {
                    res.add(i);
                }
            }
            return res;
        }

        private boolean hasCycle(int[][] graph, int start) {
            if (visited[start]) return true;
            if (isSafeNode[start]) return false;
            visited[start] = true;
            isCycleNode[start] = true;

            for (int dest : graph[start]) {
                if (hasCycle(graph, dest)) {
                    return true;
                }
            }

            visited[start] = false;
            isCycleNode[start] = false;
            isSafeNode[start] = true;
            return false;
        }
    }
}
