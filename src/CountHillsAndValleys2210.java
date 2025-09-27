public class CountHillsAndValleys2210 {
    public static void main(String[] args) {
        System.out.println(new Solution().countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
    }

    private static class Solution {
        public int countHillValley(int[] nums) {
            int n = nums.length;

            int[] rightNext = new int[n];
            rightNext[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] != nums[i + 1]) {
                    rightNext[i] = nums[i + 1];
                } else {
                    rightNext[i] = rightNext[i + 1];
                }
            }

            int[] leftNext = new int[n];
            leftNext[0] = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    leftNext[i] = nums[i - 1];
                } else {
                    leftNext[i] = leftNext[i - 1];
                }
            }

            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] == nums[i - 1]) continue;
                if ((rightNext[i] > nums[i]) && (leftNext[i] > nums[i])) {
                    count++;
                } else if ((rightNext[i] < nums[i]) && (leftNext[i] < nums[i])) {
                    count++;
                }
            }

            return count;
        }
    }
}
