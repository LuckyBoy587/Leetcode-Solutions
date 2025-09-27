import java.util.*;

public class MaximumNumberOfTargetNodes3372 {
    private static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            if (k == 0) {
                int[] res = new int[edges1.length + 1];
                Arrays.fill(res, 1);
                return res;
            }
            List<List<Integer>> graph1 = build(edges1);
            List<List<Integer>> graph2 = build(edges2);

            int tree2Count = 0;
            for (int root2 = 0; root2 < graph2.size(); root2++) {
                tree2Count = Math.max(tree2Count, countNodes(graph2, root2, -1, k - 1));
            }
            int[] res = new int[graph1.size()];
            for (int root1 = 0; root1 < graph1.size(); root1++) {
                int tree1Count = countNodes(graph1, root1, -1, k);
                System.out.println("Root: " + root1 + " Tree1: " + tree1Count + " Tree2: " + tree2Count);
                res[root1] = tree1Count + tree2Count;
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

        public int countNodes(List<List<Integer>> graph, int root, int parent, int k) {
            if (k == 0) return 1;
            int count = 1;
            for (int neighbor : graph.get(root)) {
                if (neighbor == parent) continue;
                count += countNodes(graph, neighbor, root, k - 1);
            }
            return count;
        }
    }
}
