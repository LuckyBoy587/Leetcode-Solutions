import java.util.*;

public class SortBySwapping2948 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2)));
    }
    private static class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            Integer[] indexes = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indexes[i] = i;
            }
            Arrays.sort(indexes, Comparator.comparingInt(i -> nums[i]));
            UnionFind uf = new UnionFind(nums.length);
            for (int i = 1; i < indexes.length; i++) {
                int i1 = indexes[i - 1];
                int i2 = indexes[i];

                if (nums[i2] - nums[i1] <= limit) {
                    uf.union(i1, i2);
                }
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(uf.find(i), _ -> new ArrayList<>()).add(i);
            }

            for (List<Integer> list : map.values()) {
                list.sort((i1, i2) -> nums[i2] - nums[i1]);
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int root = uf.find(i);
                List<Integer> list = map.get(root);
                result[i] = nums[list.removeLast()];
            }
            return result;
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
        }
    }
}
