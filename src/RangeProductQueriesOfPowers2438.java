import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RangeProductQueriesOfPowers2438 {
    public static void main(String[] args) {
        int n = 15;
        int[][] queries = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(new Solution().productQueries(n, queries)));
    }

    private static class Solution {
        private static final int MOD = 1000000007;

        public int[] productQueries(int n, int[][] queries) {
            SegmentTree segmentTree = new SegmentTree(getPowers(n));
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = (int) (segmentTree.query(queries[i][0], queries[i][1]) % MOD);
            }
            return res;
        }

        private List<Integer> getPowers(int n) {
            List<Integer> powerList = new ArrayList<>();
            for (int exp = 30; exp >= 0; exp--) {
                while ((1 << exp) <= n) {
                    powerList.add(1 << exp);
                    n -= (1 << exp);
                }
            }
            Collections.reverse(powerList);
            return powerList;
        }

        private static class SegmentTree {
            long[] tree;
            int n;

            public SegmentTree(List<Integer> powers) {
                n = powers.size();
                tree = new long[2 * n];
                // Build leaves
                for (int i = 0; i < n; i++) {
                    tree[n + i] = powers.get(i) % MOD;
                }
                // Build internal nodes
                for (int i = n - 1; i > 0; i--) {
                    tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
                }
            }

            private void update(int index, int value) {
                index += n;
                tree[index] = value;
                while (index > 1) {
                    index /= 2;
                    tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % MOD;
                }
            }

            private long query(int left, int right) {
                left += n;
                right += n;
                long res = 1;
                while (left <= right) {
                    if ((left & 1) == 1) {
                        res = (res * tree[left++]) % MOD;
                    }
                    if ((right & 1) == 0) {
                        res = (res * tree[right--]) % MOD;
                    }
                    left /= 2;
                    right /= 2;
                }
                return res;
            }
        }
    }
}
