import java.util.Arrays;

public class CountFairPairs2563 {
    public static void main(String[] args) {
        System.out.println(new Solution().countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    private static class Solution {
        /**
         * Counts the number of fair pairs in the array such that the sum of the elements
         * in each pair falls within the given lower and upper bounds, inclusive.
         *
         * A fair pair is a pair of elements (i, j) where:
         * - i < j
         * - The sum of the elements nums[i] + nums[j] satisfies the condition: lower <= nums[i] + nums[j] <= upper
         *
         * The input array is processed by sorting, and two sweeps with a two-pointer approach are used
         * to efficiently calculate the number of fair pairs within the specified range.
         *
         * @param nums  An array of integers to search for fair pairs.
         * @param lower The lower bound for the sum of the pairs.
         * @param upper The upper bound for the sum of the pairs.
         * @return The total number of fair pairs in the array that satisfy the conditions.
         */
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long res = 0;

            int st = 0, end = nums.length - 1;
            while (st < end) {
                while (st < end && nums[st] + nums[end] > upper) {
                    end--;
                }
                res += end - st;
                st++;
            }
            st = 0;
            end = nums.length - 1;

            while (st < end) {
                while (st < end && nums[st] + nums[end] >= lower) {
                    end--;
                }
                res -= end - st;
                st++;
            }
            return res;
        }
    }
}
