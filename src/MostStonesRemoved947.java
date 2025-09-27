import java.util.HashMap;

public class MostStonesRemoved947 {
    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        Solution solution = new Solution();
        System.out.println(solution.removeStones(stones));
    }
    private static class Solution {
        public int removeStones(int[][] stones) {
            HashMap<Integer, Integer> visitedX = new HashMap<>();
            HashMap<Integer, Integer> visitedY = new HashMap<>();

            UnionFind uf = new UnionFind(stones.length);
            for (int i = 0; i < stones.length; i++) {
                int stoneX = stones[i][0];
                int stoneY = stones[i][1];

                if (visitedX.containsKey(stoneX)) {
                    uf.union(visitedX.get(stoneX), i);
                }
                if (visitedY.containsKey(stoneY)) {
                    uf.union(visitedY.get(stoneY), i);
                }

                visitedX.put(stoneX, i);
                visitedY.put(stoneY, i);
            }

            return stones.length - uf.getGroupCount();
        }

        private static class UnionFind {
            int[] parent;
            int[] rank;
            int size;

            public UnionFind(int n) {
                parent = new int[n];
                rank = new int[n];
                size = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            private int find(int node) {
                if (parent[node] != node) {
                    parent[node] = find(parent[node]);
                }
                return parent[node];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) return;

                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                }
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public int getGroupCount() {
                int res = 0;
                for (int i = 0; i < parent.length; i++) {
                    if (parent[i] == i) res++;
                }

                return res;
            }
        }
    }
}
