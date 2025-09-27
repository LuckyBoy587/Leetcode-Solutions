import java.util.Arrays;

public class MinimumCostWalkInWeightedGraph3108 {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{3, 0, 2}, {5, 4, 12}, {6, 3, 7}, {4, 2, 2}, {6, 2, 2}};
        int[][] query = {{6, 0}};

        System.out.println(Arrays.toString(new Solution().minimumCost(n, edges, query)));
    }
    private static class Solution {
        int[] minDistances;
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            minDistances = new int[n];
            Arrays.fill(minDistances, Integer.MAX_VALUE);
            UnionFind unionFind = new UnionFind(n);
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1], weight = edge[2];
                unionFind.union(start, end, minDistances, weight);
            }

            int[] result = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                int start = query[i][0], end = query[i][1];
                if (unionFind.isConnected(start, end)) {
                    result[i] = minDistances[unionFind.find(start)];
                } else {
                    result[i] = -1;
                }
            }

            return result;
        }

        private static class UnionFind {
            int[] parent;
            int[] rank;

            public UnionFind(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int node) {
                if (parent[node] != node) {
                    parent[node] = find(parent[node]);
                }
                return parent[node];
            }

            public void union(int x, int y, int[] minDistances, int weight) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) return;
                int rankX = rank[rootX];
                int rankY = rank[rootY];

                if (rankX < rankY) {
                    parent[rootX] = rootY;
//                    minDistances[rootY] &= minDistances[rootX];
                } else if (rankX > rankY) {
                    parent[rootY] = rootX;
//                    minDistances[rootX] &= minDistances[rootY];
                } else {
                    parent[rootY] = rootX;
//                    minDistances[rootX] &= minDistances[rootY];
                    rank[rootX]++;
                }

                minDistances[rootX] = minDistances[rootY] = minDistances[rootX] & minDistances[rootY] & weight;
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
}
