public class LexographicallySmallEquivalentString1061 {
    private static class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UnionFind uf = new UnionFind(26);
            for (int i = 0; i < s1.length(); i++) {
                uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }

            StringBuilder sb = new StringBuilder();
            for (char letter: baseStr.toCharArray()) {
                int root = uf.find(letter - 'a');
                sb.append((char) ('a' + root));
            }

            return sb.toString();
        }

        static private class UnionFind {
            int[] parent;
            public UnionFind(int n) {
                parent = new int[n];
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

                if (rootX > rootY) {
                    parent[rootX] = rootY;
                }  else {
                    parent[rootY] = rootX;
                }
            }

            public boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
}
