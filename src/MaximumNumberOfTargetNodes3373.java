import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfTargetNodes3373 {
    private static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
            List<List<Integer>> graph1 = build(edges1);
            List<List<Integer>> graph2 = build(edges2);

            Value tree1Value = new Value();
            Value tree2Value = new Value();
            int[] depthArray = new int[graph1.size()];
            countNodes(graph1, 0, -1, tree1Value, 0, depthArray);
            countNodes(graph2, 0, -1, tree2Value, 0);
            int tree2MaxCount = Math.max(tree2Value.oddCount, tree2Value.evenCount);

            int[] res = new int[graph1.size()];
            for (int root1 = 0; root1 < graph1.size(); root1++) {
                if (depthArray[root1] % 2 == 0) {
                    res[root1] = tree2MaxCount + tree1Value.evenCount;
                } else {
                    res[root1] = tree2MaxCount + tree1Value.oddCount;
                }
            }
            return res;
        }

        public List<List<Integer>> build(int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= edges.length; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            return graph;
        }

        public void countNodes(List<List<Integer>> graph, int root, int parent, Value value, int depth) {
            if (depth % 2 == 0) {
                value.evenCount++;
            } else {
                value.oddCount++;
            }
            for (int neighbor : graph.get(root)) {
                if (neighbor == parent) continue;
                countNodes(graph, neighbor, root, value, depth + 1);
            }
        }

        public void countNodes(List<List<Integer>> graph, int root, int parent, Value value, int depth, int[] depthArray) {
            if (depth % 2 == 0) {
                value.evenCount++;
            } else {
                value.oddCount++;
            }
            depthArray[root] = depth;
            for (int neighbor : graph.get(root)) {
                if (neighbor == parent) continue;
                countNodes(graph, neighbor, root, value, depth + 1, depthArray);
            }
        }

        private void buildDepth(List<List<Integer>> graph, int root, int parent, int depth, int[] depthArray) {
            depthArray[root] = depth;

            for (int neighbor : graph.get(root)) {
                if (neighbor == parent) continue;
                buildDepth(graph, neighbor, root, depth + 1, depthArray);
            }
        }

        static class Value {
            int oddCount = 0;
            int evenCount = 0;

            @Override
            public String toString() {
                return "Value{" +
                        "evenCount=" + evenCount +
                        ", oddCount=" + oddCount +
                        '}';
            }
        }
    }
}
