public class RedundantConnection684 {
    private static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            boolean[] visited = new boolean[edges.length + 1];
            UnionFind uf = new UnionFind(edges.length + 1);
            int[] res = edges[0];
            for (int[] edge : edges) {
                if (visited[edge[0]] && visited[edge[1]] && uf.connected(edge[0], edge[1])) {
                    res = edge;
                }
                visited[edge[0]] = true;
                visited[edge[1]] = true;
                uf.union(edge[0], edge[1]);
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
