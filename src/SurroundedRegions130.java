public class SurroundedRegions130 {
    private static class Solution {
        int m, n;

        public void solve(char[][] board) {
            m = board.length;
            n = board[0].length;
            int SIZE = m * n;
            UnionFind uf = new UnionFind(SIZE + 1);

            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    uf.union(pos(i, 0), SIZE);
                }

                if (board[i][n - 1] == 'O') {
                    uf.union(pos(i, n - 1), SIZE);
                }
            }

            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    uf.union(pos(0, j), SIZE);
                }
                if (board[m - 1][j] == 'O') {
                    uf.union(pos(m - 1, j), SIZE);
                }
            }

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'O') {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (board[ni][nj] == 'O') {
                                uf.union(pos(i, j), pos(ni, nj));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O' && uf.find(pos(i, j)) != uf.find(SIZE)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private int pos(int i, int j) {
            return i * n + j;
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
        }
    }
}
