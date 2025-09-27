public class FindIfPathExists1971 {
    private static class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }

            return uf.connected(source, destination);
        }

        static private class UnionFind {
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
            }

            public boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
}
