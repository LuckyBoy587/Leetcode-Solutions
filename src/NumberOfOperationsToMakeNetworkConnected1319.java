public class NumberOfOperationsToMakeNetworkConnected1319 {
    private static class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length + 1 < n) return -1;
            UnionFind uf = new UnionFind(n);
            for (int[] connection : connections) {
                int start = connection[0];
                int end = connection[1];
                uf.union(start, end);
            }

            int res = 0;
            int root = uf.find(0);
            for (int i = 1; i < connections.length; i++) {
                if (!uf.connected(root, i)) {
                    res++;
                    uf.union(root, i);
                }
            }
            return res;
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
