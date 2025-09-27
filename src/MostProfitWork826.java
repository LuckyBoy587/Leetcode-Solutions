import java.util.Arrays;
import java.util.Comparator;

public class MostProfitWork826 {
    private static class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int maxProfit = 0;
            SegmentTree segmentTree = new SegmentTree(difficulty, profit);
            for (int maxDifficulty : worker) {
                int curr = segmentTree.query(maxDifficulty);
                System.out.println(curr);
                maxProfit += curr;
            }
            return maxProfit;
        }

        private static class SegmentTree {
            int[] tree;
            int n;

            public SegmentTree(int[] difficulty, int[] profit) {
                Integer[] indexes = new Integer[difficulty.length];
                n = 0;
                for (int i = 0; i < difficulty.length; i++) {
                    indexes[i] = i;
                    n = Math.max(n, difficulty[i]);
                }

                tree = new int[4 * (n + 1)];

                Arrays.sort(indexes, Comparator.comparingInt(i -> difficulty[i]));

                for (int i : indexes) {
                    update(0, 0, n, difficulty[i], profit[i]);
                }
            }

            private void update(int node, int start, int end, int idx, int val) {
                if (start == end) {
                    tree[node] = Math.max(tree[node], val);
                    return;
                }
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(2 * node + 1, start, mid, idx, val);
                } else {
                    update(2 * node + 2, mid + 1, end, idx, val);
                }
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }

            public int query(int maxDifficulty) {
                return queryUtil(0, 0, n, 0, Math.min(maxDifficulty, n));
            }

            private int queryUtil(int node, int start, int end, int l, int r) {
                if (r < start || end < l) {
                    return 0;
                }
                if (l <= start && end <= r) {
                    return tree[node];
                }
                int mid = (start + end) / 2;
                return Math.max(
                        queryUtil(2 * node + 1, start, mid, l, r),
                        queryUtil(2 * node + 2, mid + 1, end, l, r)
                );
            }
        }

    }
}
