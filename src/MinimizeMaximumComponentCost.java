import java.util.Arrays;
import java.util.Comparator;

public class MinimizeMaximumComponentCost {
    private static class Solution {
        public int minCost(int n, int[][] edges, int k) {
            if (n >= k) return 0;
            UnionFind uf = new UnionFind(n);
            Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
            int i;
            for (i = 0; uf.distinctGroups > k; i++) {
                int[] edge = edges[i];
                uf.union(edge[0], edge[1]);
            }

            return edges[i - 1][2];
        }

        static private class UnionFind {
            int[] parent;
            int[] rank;
            public int distinctGroups;
            public UnionFind(int n) {
                distinctGroups = n;
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

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) return;
                int rankX = rank[rootX];
                int rankY = rank[rootY];

                if (rankX < rankY) {
                    parent[rootX] = rootY;
                } else if (rankX > rankY) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                distinctGroups--;
            }

            public boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
}
