public class MinimizedMaximumProduct2064 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimizedMaximum(2, new int[]{5,7}));
    }
    private static class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            int res = quantities[0];
            for (int i = 1; i < quantities.length; i++) {
                res = Math.max(res, quantities[i]);
            }
            int left = 0, right = res;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canSplit(quantities, mid, n)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canSplit(int[] quantities, int maxAlloc, int n) {
            if (maxAlloc == 0) return false;
            int count = 0;
            for (int quantity: quantities) {
                count += quantity / maxAlloc;
                if (quantity % maxAlloc != 0) {
                    ++count;
                }
            }
            return count <= n;
        }
    }
}
