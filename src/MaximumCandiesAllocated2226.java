public class MaximumCandiesAllocated2226 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,10};
        int k = 5;
        System.out.println(new Solution().maximumCandies(arr, k));
    }

    private static class Solution {
        public int maximumCandies(int[] candies, long k) {
            int left = 1, right = 0, res = 0;
            for (int candy : candies) {
                right = Math.max(right, candy);
            }

            while (left <= right) {
                int split = left + (right - left) / 2;
                if (canAllocate(candies, k, split)) {
                    res = split;
                    left = split + 1;
                } else {
                    right = split - 1;
                }
            }

            return res;
        }

        private boolean canAllocate(int[] candies, long childCount, long split) {
            for (int candy: candies) {
                childCount -= candy / split;
                if (childCount <= 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
