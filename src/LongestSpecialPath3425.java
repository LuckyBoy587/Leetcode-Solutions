import java.util.*;

public class LongestSpecialPath3425 {
    private static class Solution {
        int[] values;
        boolean[] visited;
        private static final List<int[]> EMPTY = new ArrayList<>();
        public int[] longestSpecialPath(int[][] edges, int[] nums) { // {length, nodeCount}
            values = nums;
            visited = new boolean[nums.length];
            HashMap<Integer, List<int[]>> graph = new HashMap<>();
            int[] indegree = new int[nums.length];
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1], length = edge[2];
                graph.computeIfAbsent(start, _ -> new ArrayList<>()).add(new int[]{end, length});
                indegree[end]++;
            }

            Integer[] nodes = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) nodes[i] = i;
            Arrays.sort(nodes, Comparator.comparingInt(i -> indegree[i]));

            int[] res = {0, 1};
            for (int start: nodes) {
                if (!visited[start]) {
                    System.out.println(start);
                    res = compareOutput(res, dfs(graph, start, new int[]{0, 1}, new HashSet<>()));
                }
            }

            return res;
        }

        private int[] dfs(HashMap<Integer, List<int[]>> graph, int start, int[] result, HashSet<Integer> visitedValues) {
            if (visitedValues.contains(values[start])) return new int[]{0, 1};
            visitedValues.add(values[start]);
            visited[start] = true;

            int[] res = result;
            for (int[] edge: graph.getOrDefault(start, EMPTY)) {
                int[] output = dfs(graph, edge[0], new int[]{result[0] + edge[1], result[1] + 1}, visitedValues);
                res = compareOutput(res, output);
            }

            visitedValues.remove(values[start]);
            return res;
        }

        private int[] compareOutput(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) return o1;
            if (o2[0] > o1[0]) return o2;
            if (o1[1] < o2[1]) return o1;
            return o2;
        }
    }
}
