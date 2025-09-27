import java.util.*;

public class PropertiesGraph {
    private static class Solution {
        public int numberOfComponents(int[][] properties, int k) {

            List<Set<Integer>> components = new ArrayList<>();
            for (int[] property : properties) {
                HashSet<Integer> set = new HashSet<>();
                for (int node: property) {
                    set.add(node);
                }
                components.add(set);
            }

            UnionFind uf = new UnionFind(properties.length);
            for (int i = 0; i < properties.length; i++) {
                for (int j = i + 1; j < properties.length; j++) {
                    if (getIntersectionLength(components.get(i), components.get(j)) >= k) {
                        uf.union(i, j);
                    }
                }
            }

            int res = 0;
            for (int node = 0; node < properties.length; node++) {
                if (uf.parent[node] == node) {
                    res++;
                }
            }
//            System.out.println(Arrays.toString(uf.parent));
            return res;
        }

        private int getIntersectionLength(Set<Integer> set1, Set<Integer> set2) {
            Set<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);
            return intersection.size();
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
                if (rootX == rootY) {
                    return;
                }
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
