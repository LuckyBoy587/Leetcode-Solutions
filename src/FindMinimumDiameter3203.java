import java.util.*;

public class FindMinimumDiameter3203 {
    public static void main(String[] args) {
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {2, 4},
                {2, 5},
                {3, 6},
                {2, 7}
        };

        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {2, 4},
                {2, 5},
                {3, 6},
                {2, 7}
        };
        System.out.println(new Solution().minimumDiameterAfterMerge(edges1, edges2));
    }

    private static class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            int m = edges1.length + 1;
            int n = edges2.length + 1;

            int diameter1 = getDiameter(getAdjacencyMatrix(edges1, m), m);
            int diameter2 = getDiameter(getAdjacencyMatrix(edges2, n), n);

            int newDiameter = (int) (Math.ceil((diameter1) / 2.0) + Math.ceil((diameter2) / 2.0) + 1.0);
            return Math.max(newDiameter, Math.max(diameter1, diameter2));
        }

        private int getDiameter(List<Integer>[] adjMatrix, int size) {
            int farthestNode = getDetails(adjMatrix, size, 0)[0];
            return getDetails(adjMatrix, size, farthestNode)[1];
        }

        private List<Integer>[] getAdjacencyMatrix(int[][] edges, int size) {
            List<Integer>[] adjMatrix = new List[size];
            for (int i = 0; i < size; i++) {
                adjMatrix[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1];
                adjMatrix[start].add(end);
                adjMatrix[end].add(start);
            }
            return adjMatrix;
        }

        private int[] getDetails(List<Integer>[] adjMatrix, int size, int start_node) {
            int farthestNode = start_node;
            int[] depth = new int[size];
            Arrays.fill(depth, -1);
            depth[start_node] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start_node);

            while (!queue.isEmpty()) {
                int start = queue.poll();

                for (int dest : adjMatrix[start]) {
                    if (depth[dest] == -1) {
                        queue.add(dest);
                        depth[dest] = depth[start] + 1;
                        farthestNode = dest;
                    }
                }
            }
            return new int[]{farthestNode, depth[farthestNode]};
        }
    }
}
