import java.util.Arrays;

public class LongestHarmoniousSubsequence594 {
    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    private static class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int index = 0;
            while (index < nums.length && nums[index] == nums[0]) index++;
            int res = 0, prevCount = index;
            int prevNumber = nums[0];
            while (index < nums.length) {
                int start = index;
                while (index < nums.length && nums[index] == nums[start]) index++;
                int currCount = index - start;
                if (prevNumber + 1 == nums[start]) {
                    res = Math.max(res, currCount + prevCount);
                }
                prevCount = currCount;
                prevNumber = nums[start];
            }

            return res;
        }
    }
}
