import java.util.ArrayList;
import java.util.List;

public class ProcessRestrictedRequest2076 {
    private static class Solution {
        public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
            RollbackUnionFind rollbackUF = new RollbackUnionFind(n);
            boolean[] res = new boolean[requests.length];
            for (int i = 0; i < requests.length; i++) {
                int u = requests[i][0];
                int v = requests[i][1];
                if (rollbackUF.isConnected(u, v)) {
                    res[i] = true;
                    continue;
                }
                int logSize = rollbackUF.logs.size();
                rollbackUF.union(u, v);
                if (canBecomeFriends(rollbackUF, restrictions)) {
                    res[i] = true;
                } else {
                    rollbackUF.undo(rollbackUF.logs.size() - logSize);
                }
            }

            return res;
        }

        private boolean canBecomeFriends(UnionFind uf, int[][] restrictions) {
            for (int[] restriction: restrictions) {
                if (uf.isConnected(restriction[0], restriction[1])) {
                    return false;
                }
            }

            return true;
        }

        private static class UnionFind {
            int[] parent;
            int[] rank;
            int size;

            public UnionFind(int n) {
                this.size = n;
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }

                return parent[x];
            }

            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return;
                }

                if (rank[xRoot] < rank[yRoot]) {
                    parent[xRoot] = yRoot;
                    rank[yRoot]++;
                } else {
                    parent[yRoot] = xRoot;
                    rank[xRoot]++;
                }
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }
        }

        static class RollbackUnionFind extends UnionFind {
            List<int[]> logs = new ArrayList<>(); // for rollback (stores [x, oldParent])

            public RollbackUnionFind(int n) {
                super(n);
            }

            @Override
            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) return;

                if (rank[xRoot] < rank[yRoot]) {
                    logs.add(new int[]{xRoot, parent[xRoot]});
                    parent[xRoot] = yRoot;
                } else {
                    logs.add(new int[]{yRoot, parent[yRoot]});
                    parent[yRoot] = xRoot;
                    if (rank[xRoot] == rank[yRoot]) {
                        logs.add(new int[]{-1, xRoot}); // sentinel for rank increment
                        rank[xRoot]++;
                    }
                }
            }

            public void undo(int count) {
                while (count-- > 0) {
                    int[] log = logs.removeLast();
                    if (log[0] == -1) { // sentinel, undo rank
                        rank[log[1]]--;
                    } else {
                        parent[log[0]] = log[1];
                    }
                }
            }
        }
    }
}
