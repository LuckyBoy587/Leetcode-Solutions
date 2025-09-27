public class NumberOfCompleteComponents2685 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(new Solution().countCompleteComponents(n, edges));
    }
    private static class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            int[] edgeCount = new int[n];
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1], edgeCount);
            }
            int[] nodeCount = new int[n];
            for (int i = 0; i < n; i++) {
                nodeCount[uf.find(i)]++;
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                if (nodeCount[i] == 0) continue;
                if ((nodeCount[i] * (nodeCount[i] - 1)) / 2 == edgeCount[i]) {
                    res++;
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

            public void union(int x, int y, int[] edgeCount) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    edgeCount[rootX]++;
                    return;
                }
                int rankX = rank[rootX];
                int rankY = rank[rootY];

                if (rankX < rankY) {
                    parent[rootX] = rootY;
                    edgeCount[rootY] += edgeCount[rootX] + 1;
                } else if (rankX > rankY) {
                    parent[rootY] = rootX;
                    edgeCount[rootX] += edgeCount[rootY] + 1;
                } else {
                    parent[rootY] = rootX;
                    edgeCount[rootX] += edgeCount[rootY] + 1;
                    rank[rootX]++;
                }
            }

            public boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
}
